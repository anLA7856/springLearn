package com.anla.springaop.service;

import com.anla.springaop.AopApplication;
import com.anla.springaop.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Test
    public void test(){
        log.info(testService.hello("spring aop"));
        log.info("equals:{}",testService.equals("!23"));
        log.info("equals:{}",testService.hashCode());
        log.info("equals:{}",testService.toString());
        log.info(worldService.world("world aop"));
    }
}
