package com.anla.springbean.componet.postcontstruct;

import com.anla.springbean.componet.primary.Boy;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author anLA7856
 * @date 20-3-8 下午9:25
 * @description
 */
@Configuration
public class DemoPostConstruct {

    @Resource
    private Boy boy;

    @PostConstruct
    public void testPostConstruct(){
        System.out.println("It's started. testPostConstruct...");
    }

    @PreDestroy
    public void testPreDestroy(){
        System.out.println("It's destory?? testPreDestroy");
    }

    public void testResource(){
        System.out.println("It's from boy say?");
        boy.say();
    }
}
