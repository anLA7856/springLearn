package com.anla.springaop.service;

import com.anla.springaop.AopApplication;
import com.anla.springaop.advisor.IOther;
import com.anla.springaop.advisor.OtherService;
import com.anla.springaop.advisor.SomeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 11:21
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AopApplication.class)
@WebAppConfiguration
@Slf4j
public class HelloServiceTest {
    @Autowired
    HelloService testService;

    @Autowired
    WorldAPI worldService;

    @Autowired
    SomeService someService;

    @Autowired
    OtherService otherService;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test(){
        log.info(testService.hello("spring aop"));
        log.info("equals:{}",testService.equals("!23"));
        log.info("equals:{}",testService.hashCode());
        log.info("equals:{}",testService.toString());
        log.info(worldService.world("world aop"));
    }

    /**
     * 强转后，是不是有了，牛逼
     */
    @Test
    public void doSomeTest(){
        someService.doSome();
        ((IOther)someService).doOther();
    }

    @Test
    public void doOtherTest(){
        otherService.doOther();
    }

    @Test
    public void doProxyFactory(){
//        ProxyFactory proxyFactory=new ProxyFactory();
//        proxyFactory.setTarget(new TestMethodInterceptor());
//        proxyFactory.addAdvice(new adviseMethodInterceptor());
//
//        Object proxy = proxyFactory.getProxy();
//        TestMethodInterceptor methodInterceptor = (TestMethodInterceptor) proxy;
//
//        methodInterceptor.doSomeThing("通过代理工厂设置代理对象，拦截代理方法");
    }
}
