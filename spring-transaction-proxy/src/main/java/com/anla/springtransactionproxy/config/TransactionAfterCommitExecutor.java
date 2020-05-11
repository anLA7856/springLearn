package com.anla.springtransactionproxy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 事务提交异步线程
 * @author luoan
 */
public class TransactionAfterCommitExecutor extends ThreadPoolExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionAfterCommitExecutor.class);


    public TransactionAfterCommitExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public TransactionAfterCommitExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public TransactionAfterCommitExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public TransactionAfterCommitExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }


    private ThreadLocal<List<Runnable>> currentRunables = new ThreadLocal<List<Runnable>>(){
        @Override
        protected List<Runnable> initialValue() {
            return new ArrayList<>(5);
        }
    };

    private ThreadLocal<Boolean> registed = new ThreadLocal<Boolean>(){
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };

    /**
     * 默认策略丢弃最老的数据
     */
    public TransactionAfterCommitExecutor() {
        this(
                50, 500,
                500L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                },
                new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    @Override
    public void execute(final Runnable runnable) {
        //如果事务同步未启用,即不在事务中，则立即执行
        if (!TransactionSynchronizationManager.isSynchronizationActive()) {
            super.execute(runnable);
        } else {
            //同一个事务的合并到一起处理
            currentRunables.get().add(runnable);
            //如果存在事务则在事务结束后异步处理
            if(!registed.get()){
                // 注意，这个只在当次线程起作用。registerSynchronization 最终是放到本地线程变量中。
                TransactionSynchronizationManager.registerSynchronization(new AfterCommitTransactionSynchronizationAdapter());
                registed.set(true);
            }
        }
    }

    @Override
    public Future<?> submit(final Runnable runnable) {
        //如果事务同步未启用则认为事务已经提交，马上进行异步处理
        if (!TransactionSynchronizationManager.isSynchronizationActive()) {
            return super.submit(runnable);
        } else {
            final RunnableFuture<Void> ftask = newTaskFor(runnable, null);
            //如果存在事务则在事务结束后异步处理
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
                    TransactionAfterCommitExecutor.super.submit(ftask);
                }
            });
            return ftask;
        }
    }

    private class AfterCommitTransactionSynchronizationAdapter extends TransactionSynchronizationAdapter{
        @Override
        public void afterCompletion(int status) {
            final List<Runnable> txRunables = new ArrayList<>(currentRunables.get());
            currentRunables.remove();
            registed.remove();
            if(status == STATUS_COMMITTED){
                TransactionAfterCommitExecutor.super.execute(new Runnable() {
                    @Override
                    public void run() {
                        for (Runnable runnable : txRunables) {
                            try {
                                runnable.run();
                            } catch (Exception e) {
                                LOGGER.error("ex:",e);
                            }
                        }
                    }
                });
            }
        }
    }
}
