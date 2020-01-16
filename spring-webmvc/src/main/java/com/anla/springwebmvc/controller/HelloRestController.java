package com.anla.springwebmvc.controller;

import com.anla.springwebmvc.model.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直接返回对象
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 16:29
 **/
@RestController("helloRest")
public class HelloRestController {

    @GetMapping
    public Hello hello(){
        return new Hello("123123", 1);
    }
}
