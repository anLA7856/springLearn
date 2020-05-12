package com.anla.springwebmvc.servlet;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/12 15:51
 **/
public class Deadlock
{
    public static void main(String arg[]) throws InterruptedException {
        ReentrantReadWriteLock lock1, lock2;
        ThreadMXBean bean;

        lock1 = new ReentrantReadWriteLock();
        lock2 = new ReentrantReadWriteLock();

        new Thread(() -> deadlocker(lock1, lock2)).start();
        new Thread(() -> deadlocker(lock2, lock1)).start();
        new Thread(() -> lockUnlock(lock1.writeLock())).start();
        new Thread(() -> lockUnlock(lock2.writeLock())).start();

        bean = ManagementFactory.getThreadMXBean();

        while (bean.findDeadlockedThreads() == null)
            Thread.sleep(1000);

        System.out.println("Deadlock detected");
    }

    private static void deadlocker(ReentrantReadWriteLock lock1, ReentrantReadWriteLock lock2)               // TODO - Remove this
    {
        lock1.readLock().lock();
        lockUnlock(lock2.readLock());
    }

    private static void lockUnlock(Lock lock)
    {
        while (true)
        {
            lock.lock();
            lock.unlock();
        }
    }
}