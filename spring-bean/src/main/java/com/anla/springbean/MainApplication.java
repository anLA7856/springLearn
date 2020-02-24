package com.anla.springbean;

import com.anla.springbean.componet.TestComponentScan;
import com.anla.springbean.componet.sub.Bird;
import com.anla.springbean.componet.sub1.Bug;
import com.anla.springbean.config.*;
import com.anla.springbean.model.Dog;
import com.anla.springbean.model.Tomdog;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/2/24 11:50
 **/
public class MainApplication {
    private static AnnotationConfigApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = new AnnotationConfigApplicationContext();;
        setupTomdog();
    }

    private static void setupTomdog() {
        GenericBeanDefinition definition = new GenericBeanDefinition();
        definition.setBeanClass(Tomdog.class);
        definition.getPropertyValues().add("dog",  new Dog());
        applicationContext.registerBeanDefinition("tomdog", definition);


        applicationContext.register(TestComponentScan.class,
                DogBeanPostProcessor.class,
                CommonConfiguration.class,
                ApplicationListenerConfiguration.class,
                BeanFactoryPostProcessorConfiguration.class,
                BeanDefinitionRegistryPostProcessorConfiguration.class);
        // 这样方式，就可以将 BeanFactoryPostProcessor 放到  PostProcessorRegistrationDelegate 中执行
        applicationContext.addBeanFactoryPostProcessor(new BeanFactoryPostProcessorConfiguration());
        applicationContext.addBeanFactoryPostProcessor(new BeanDefinitionRegistryPostProcessorConfiguration());

        startContext();

        Dog dog = applicationContext.getBean("dog", Dog.class);
        System.out.println(dog.afterWangwang());

        Tomdog tomdog = applicationContext.getBean("tomdog", Tomdog.class);
        System.out.println(tomdog.dogwangwang());

        Bird bird = applicationContext.getBean("bird", Bird.class);
        bird.hello();

        Bug bug = applicationContext.getBean("bug", Bug.class);
        bug.hello();

    }


    private static void startContext() {
        applicationContext.refresh();
        applicationContext.start();

        // this will throw an exception if the beans cannot be found
        applicationContext.getBean("tomdog");
    }
}