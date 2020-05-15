package com.anla.springwebmvc.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/15 14:13
 **/
@Service
@RequestScope
public class RequestScopeService implements DisposableBean {


    public  void helloScope(){
        System.out.println("Hello RequestScopeService");
    }

    public RequestScopeService() {
        System.out.println("I am RequestScopeService, I am construct");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("I am RequestScopeService, I am destroying");
    }
}
