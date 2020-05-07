package com.anla.springaop.advisor;

import org.springframework.stereotype.Component;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/7 11:56
 **/
@Component
public class SomeService{
    public void doSome() {
        System.out.println("do some...");
    }
}
