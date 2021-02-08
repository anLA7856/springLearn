package com.anla.springapollo.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/12/14 14:25
 **/
@RestController
@Slf4j
@RequestMapping("helloRest")
public class HelloController {

    @Value("${spring.datasource.password}")
    private String password;


    @Autowired
    private MqProperty mqProperty;

    @Autowired
    private TempNamespace tempNamespace;

    @GetMapping("/hello")
    public Integer hello(){
        Config one = ConfigService.getAppConfig(); //获取当前应用id下指定环境内的application.properties配置文件
        Config two = ConfigService.getConfig("application"); //获取当前应用id下指定环境内的xxxx配置文件或指定的公共配置文件
        String value = one.getProperty("spring.redis.host", "123"); //获取配置项。参数一：属性key；参数二：当属性key无value时设置默认值
        System.out.println("value is :"+value);
        System.out.println("password is :"+password);
        System.out.println("mqProperty is :" + mqProperty);
        System.out.println("tempNamespace is :" + tempNamespace);
        return 0;
    }



}
