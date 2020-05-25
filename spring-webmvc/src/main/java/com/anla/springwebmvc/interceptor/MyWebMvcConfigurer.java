package com.anla.springwebmvc.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 这个类在 Spring 初始化 DelegatingWebMvcConfiguration 类时候被配置。
 * @author luoan
 * @version 1.0
 * @date 2020/5/23 13:14
 **/
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    @Qualifier("myOtherHandlerInterceptor")
    private MyOtherHandlerInterceptor myOtherHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可以添加一个拦截其
        registry.addInterceptor(myOtherHandlerInterceptor)
                .addPathPatterns("/**");
//                .excludePathPatterns("/sms/record/receiveStatus");
    }
}
