package com.anla.springwebmvc.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * 1. springmvc 3.2开始就支持servlet3.0的异步请求。
 * 平常我们请求一个controller一般都是同步的，如果在代码执行中，遇到耗时的业务操作，
 * 那servlet容器线程就会被锁死，当有其他请求进来的时候就会受堵了。
 * 不让其他线程堵死
 *
 * 2. 注意：异步模式对前端来说，是无感知的，这是后端的一种技术。所以这个和我们自己开启一个线程处理，立马返回给前端是有非常大的不同的，需要注意~
 *
 * 3. 异步模式处理步骤如下：
 * - 当Controller返回值是Callable的时候
 * - Spring就会将Callable交给TaskExecutor去处理（一个隔离的线程池）
 * - 与此同时将DispatcherServlet里的拦截器、Filter等等都马上退出主线程，但是response仍然保持打开的状态
 * - Callable线程处理完成后，Spring MVC讲请求重新派发给容器**（注意这里的重新派发，和后面讲的拦截器密切相关）**
 * - 根据Callabel返回结果，继续处理（比如参数绑定、视图解析等等就和之前一样了）~~~~
 * @author luoan
 * @version 1.0
 * @date 2020/5/26 15:36
 **/
@Controller
@RequestMapping("/async")
public class AsyncController {


    /**
     * 直接返回 Callable
     * @return
     */
    @RequestMapping("/mvc25")
    @ResponseBody
    public Callable<String> mvc25() {

        System.out.println(Thread.currentThread().getName() + " 主线程start");

        Callable<String> callable = () -> {
            System.out.println(Thread.currentThread().getName() + " 子子子线程start");
            TimeUnit.SECONDS.sleep(5); //模拟处理业务逻辑，话费了5秒钟
            System.out.println(Thread.currentThread().getName() + " 子子子线程end");

            // 这里稍微小细节一下：最终返回的不是Callable对象，而是它里面的内容
            return "hello world";
        };

        System.out.println(Thread.currentThread().getName() + " 主线程end");
        return callable;
    }


    /**
     * 使用 WebAsyncTask 替代Callable
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/webAsyncTask")
    public WebAsyncTask<String> webAsyncTask() throws Exception {
        System.out.println(Thread.currentThread().getName() + " 主线程start");

        Callable<String> callable = () -> {
            System.out.println(Thread.currentThread().getName() + " 子子子线程start");
            TimeUnit.SECONDS.sleep(5); //模拟处理业务逻辑，话费了5秒钟
            System.out.println(Thread.currentThread().getName() + " 子子子线程end");
            return "hello world";
        };

        // 采用WebAsyncTask 返回 这样可以处理超时和错误 同时也可以指定使用的Excutor名称
        WebAsyncTask<String> webAsyncTask = new WebAsyncTask<>(3000, callable);
        // 注意：onCompletion表示完成，不管你是否超时、是否抛出异常，这个函数都会执行的
        webAsyncTask.onCompletion(() -> System.out.println("程序[正常执行]完成的回调"));

        // 这两个返回的内容，最终都会放进response里面去===========
        webAsyncTask.onTimeout(() -> "程序[超时]的回调");
        // 备注：这个是Spring5新增的
        webAsyncTask.onError(() -> "程序[出现异常]的回调");


        System.out.println(Thread.currentThread().getName() + " 主线程end");
        return webAsyncTask;
    }




    private List<DeferredResult<String>> deferredResultList = new ArrayList<>();


    /**
     * 使用 DeferredResult 方式
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/deferredStart")
    public DeferredResult<String> deferredStart() throws Exception {
        DeferredResult<String> deferredResult = new DeferredResult<>();

        //先存起来，等待触发
        deferredResultList.add(deferredResult);
        return deferredResult;
    }

    @ResponseBody
    @GetMapping("/deferredEnd")
    public void deferredEnd() throws Exception {
        // 让所有hold住的请求给与响应  直到 setResult时候，前一个 deferredStart 才会返回。
        deferredResultList.forEach(d -> d.setResult("say hello to all"));
    }
}
