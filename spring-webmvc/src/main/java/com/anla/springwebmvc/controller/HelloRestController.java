package com.anla.springwebmvc.controller;

import com.anla.springwebmvc.config.CommonConfiguration;
import com.anla.springwebmvc.config.TestConfig;
import com.anla.springwebmvc.model.Hello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @Autowired
    private TestConfig testConfig;

    @GetMapping("/hello")
    public Hello hello(){
        log.info("@Value 形式 :{}" + commonConfiguration.getMsg());
        log.info("ConfigurationProperties 形式 :{}" + testConfig.getMsg());
        return new Hello("123123", 1);
    }


    @GetMapping("/hello1")
    public Object hello1(){
        return "12323,1";
    }

    @GetMapping("/hello2")
    public Integer hello2(){
        return 1;
    }

}
