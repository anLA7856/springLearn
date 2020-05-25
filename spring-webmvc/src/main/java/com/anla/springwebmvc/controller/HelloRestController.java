package com.anla.springwebmvc.controller;

import com.anla.springwebmvc.config.CommonConfiguration;
import com.anla.springwebmvc.config.TestConfig;
import com.anla.springwebmvc.model.Hello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直接返回对象
 *
 * @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
 * 1) 如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，或者html，配置的视图解析器 InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 * 2) 如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 *     如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 16:29
 **/
@RestController
@Slf4j
@RequestMapping("helloRest")
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
