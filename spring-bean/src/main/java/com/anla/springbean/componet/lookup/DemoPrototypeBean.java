package com.anla.springbean.componet.lookup;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/3/2 13:48
 **/
@Component
@Scope("prototype")
public class DemoPrototypeBean {

    public void say() {
        System.out.println("say something...");
    }
}
