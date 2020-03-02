package com.anla.springbean.componet.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 *
 * 使用lookup注解，可以使 DemoPrototypeBean 每次都是不一样的。
 * @author luoan
 * @version 1.0
 * @date 2020/3/2 13:39
 **/
@Component
public abstract class DemoTrueLookUpConfiguration {


    public void print() {
        DemoPrototypeBean bean = methodInject();
        System.out.println("Bean SingletonBean's HashCode" + bean.hashCode());
        bean.say();
    }


    @Lookup
    protected abstract DemoPrototypeBean methodInject();
}
