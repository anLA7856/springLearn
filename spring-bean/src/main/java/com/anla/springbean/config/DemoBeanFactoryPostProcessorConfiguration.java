package com.anla.springbean.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author anLA7856
 * @date 20-1-12 下午11:02
 * @description
 */
public class DemoBeanFactoryPostProcessorConfiguration implements BeanFactoryPostProcessor {
    /**
     * 注意顺序
     * https://www.jianshu.com/p/3d099ea43b0e
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory 类型:" + beanFactory.getClass());
        System.out.println("我要不要动你个小子呢？" + beanFactory.getBeanDefinitionNames().toString());
    }
}
