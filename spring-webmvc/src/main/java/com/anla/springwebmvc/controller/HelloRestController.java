package com.anla.springwebmvc.controller;

import com.anla.springwebmvc.config.CommonConfiguration;
import com.anla.springwebmvc.model.Hello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直接返回对象
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 16:29
 **/
@RestController("helloRest")
@Slf4j
public class HelloRestController {

    @Autowired
    private CommonConfiguration commonConfiguration;

    @GetMapping
    public Hello hello(){
        log.info(commonConfiguration.getMsg());
        return new Hello("123123", 1);
    }

}
