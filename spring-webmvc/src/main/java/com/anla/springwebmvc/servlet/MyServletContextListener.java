package com.anla.springwebmvc.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/11 20:20
 **/
@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("My own contextInitialized " + sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Sorry My own contextDestroyed " + sce);
    }
}
