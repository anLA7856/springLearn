package com.anla.springbean.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author anLA7856
 * @date 20-1-12 下午10:48
 * @description
 */
@Configuration
public class DemoApplicationListenerConfiguration implements ApplicationListener {

    /**
     * 所有事件都打印出
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(" 事件为" + event.getClass());
    }
}
