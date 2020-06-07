package com.anla.springwebmvc.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.support.WebContentGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义 AbstractController 例子
 *
 * @author luoan
 * @version 1.0
 * @date 2020/5/29 15:24
 **/
@Component
public class MyDirectController extends AbstractController implements InitializingBean {


    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("执行了AbstractController处理器！！！");
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.setSupportedMethods(WebContentGenerator.METHOD_GET);
    }
}
