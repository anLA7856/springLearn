package com.anla.springbean.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/3/5 13:40
 **/
public class DemoDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

    /**
     * 默认实现这一个就好了
     * @param bean
     * @param beanName
     * @throws BeansException
     */
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        System.out.println("I am destroying... " + beanName + "beaninstance is " + bean);
    }

    @Override
    public boolean requiresDestruction(Object bean) {
        System.out.println("call me requiresDestruction");
        return true;
    }

}
