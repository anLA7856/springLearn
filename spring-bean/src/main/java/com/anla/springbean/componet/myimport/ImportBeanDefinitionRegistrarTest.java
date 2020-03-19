package com.anla.springbean.componet.myimport;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 是先import 作为beanDefinition，而后才执行  registerBeanDefinitions 方法，
 * 是在 ConfigurationClassBeanDefinitionReader 的 loadBeanDefinitionsForConfigurationClass 中。
 * @author anLA7856
 * @date 20-3-19 下午10:43
 * @description
 */
public class ImportBeanDefinitionRegistrarTest implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(ImportTestC.class);
        registry.registerBeanDefinition("importTestC", rootBeanDefinition);
    }
}
