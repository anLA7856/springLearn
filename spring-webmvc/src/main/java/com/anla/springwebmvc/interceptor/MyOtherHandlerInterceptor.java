package com.anla.springwebmvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 海川就是用这个
 *
 * 这个interceptor 最终，会被包装进 HandlerExecutionChain，即获取handler时候包装。
 * @author luoan
 * @version 1.0
 * @date 2020/5/23 13:05
 **/
@Component
public class MyOtherHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyOtherHandlerInterceptor is calling preHandle...");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyOtherHandlerInterceptor is calling postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyOtherHandlerInterceptor is calling afterCompletion...");
    }
}
