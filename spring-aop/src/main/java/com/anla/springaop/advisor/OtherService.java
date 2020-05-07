package com.anla.springaop.advisor;

import org.springframework.context.annotation.Configuration;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/7 14:11
 **/
@Configuration
public class OtherService implements IOther {

    /**
     * 实现doOther方法
     */
    @Override
    public void doOther() {
        System.out.println("do other ...");
    }

}
