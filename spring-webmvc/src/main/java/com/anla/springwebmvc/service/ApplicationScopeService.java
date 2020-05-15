package com.anla.springwebmvc.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/15 14:13
 **/
@Service
@ApplicationScope
public class ApplicationScopeService implements DisposableBean {

    public  void helloScope(){
        System.out.println("Hello ApplicationScopeService");
    }

    public ApplicationScopeService() {
        System.out.println("I am ApplicationScope, I am construct");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("I am ApplicationScope, I am destroying");
    }
}
