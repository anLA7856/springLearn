package com.anla.springbean.config;

import com.anla.springbean.model.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author anLA7856
 * @date 20-1-12 下午10:29
 * @description
 */
@Configuration
public class DogBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Dog) {
            Dog dog = (Dog) bean;
            System.out.println("tell dog:" + dog.wangwang());
            return bean;
        }
        return bean;

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Dog) {
            Dog dog = (Dog) bean;
            System.out.println("I have told dog:" + dog.afterWangwang());
            return bean;
        }
        return bean;
    }
}
