package com.anla.springbean.componet.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * 虽然 DemoPrototypeBean 标明是 prototype的，但是这个bean还是每次都是一样。
 * @author luoan
 * @version 1.0
 * @date 2020/3/2 13:39
 **/
@Component
public class DemoWrongLookUpConfiguration {

    @Autowired
    private DemoPrototypeBean bean;

    public void print() {
        System.out.println("Bean SingletonBean's HashCode" + bean.hashCode());
        bean.say();
    }
}
