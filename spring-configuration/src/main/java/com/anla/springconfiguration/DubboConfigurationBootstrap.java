package com.anla.springconfiguration;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/3/19 17:39
 **/
public class DubboConfigurationBootstrap {
    public static void main(String[] args) {
        // 创建配置上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册当前配置 Bean
         context.register(DubboMultipleWithoutConfiguration.class);
        context.register(DubboMultipleConfiguration.class);
        // context.register(DubboMultipleYmlConfiguration.class);
        context.refresh();

        // 获取 ApplicationConfig Bean："applicationBean"、"applicationBean2" 和 "applicationBean3"
        ApplicationConfig applicationBean = context.getBean("applicationBean", ApplicationConfig.class);
        ApplicationConfig applicationBean2 = context.getBean("applicationBean2", ApplicationConfig.class);
        ApplicationConfig applicationBean3 = context.getBean("applicationBean3", ApplicationConfig.class);

        System.out.printf("applicationBean.name = %s \n", applicationBean.getName());
        System.out.printf("applicationBean2.name = %s \n", applicationBean2.getName());
        System.out.printf("applicationBean3.name = %s \n", applicationBean3.getName());
    }

    @EnableDubboConfig(multiple = true)
//    @PropertySource("META-INF/multiple-config.properties")
    private static class DubboMultipleConfiguration {

    }

    /**
     * 这样配置，前面EnableDubboConfig 也能拿到配置
     */
    @Configuration
    @PropertySource("META-INF/multiple-config.properties")
    private static class DubboMultipleWithoutConfiguration{
        public DubboMultipleWithoutConfiguration() {
        }
     }

    /**
     * PropertySource 只支持properties文件
     */
    @EnableDubboConfig(multiple = true)
    @PropertySource("META-INF/multiple-config.yml")
    private static class DubboMultipleYmlConfiguration {

    }
}
