package com.anla.springwebmvc.interceptor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.MappedInterceptor;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/23 13:02
 **/
@Configuration
public class MyMappedInterceptor {



    @Bean
    public MappedInterceptor mappedInterceptor(@Qualifier("myHandlerInterceptor") HandlerInterceptor handlerInterceptor){
        String[] str = {"/index"};
        return new MappedInterceptor(str, handlerInterceptor);
    }
}
