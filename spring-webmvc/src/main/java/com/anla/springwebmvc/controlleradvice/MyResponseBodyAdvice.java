package com.anla.springwebmvc.controlleradvice;

import com.anla.springwebmvc.model.Hello;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/23 16:43
 **/
//@Configuration
//@RestControllerAdvice("com.anla.springwebmvc.controller.HelloRestController")
@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof Hello){
            System.out.println("hello? beforeBodyWrite");
            return body;
        } else{
            // 处理字符数组
            return body;
        }
    }
}
