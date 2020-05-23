package com.anla.springwebmvc.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/9 9:42
 **/
@Service
public class HelloService {


    /**
     * 只在这里面也可以
     * todo 好像不可以
     * @return
     */
    @GetMapping("helloHelloService")
    public String helloHelloService() {
        return "helloHelloService";
    }
}
