package com.anla.springwebmvc.async;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/26 17:26
 **/
@Component
public class AsyncHelloInterceptor implements AsyncHandlerInterceptor {
    /**
     * 这是Spring3.2提供的方法，专门拦截异步请求的方式
     * @param request
     * @param response
     * @param handler
     * @throws Exception
     */
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(Thread.currentThread().getName() + "---afterConcurrentHandlingStarted-->" + request.getRequestURI());
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(Thread.currentThread().getName() + "---preHandle-->" + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(Thread.currentThread().getName() + "---postHandle-->" + request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(Thread.currentThread().getName() + "---afterCompletion-->" + request.getRequestURI());
    }
}
