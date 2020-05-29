package com.anla.springwebmvc.config;

import com.anla.springwebmvc.controller.MyDirectController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Collections;
import java.util.Properties;

/**
 * kill 时 hook
 * @author luoan
 * @version 1.0
 * @date 2020/2/21 11:04
 **/
@Slf4j
@Configuration
public class CommonConfiguration implements DisposableBean {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${anla.msg}")
    private String msg;

    @Override
    public void destroy() throws Exception {
        if (applicationName == null){
            log.error("错误，获取不到 applicationName");
            return;
        }
        log.info("{} 正被关闭", applicationName);
        doDestroy();
    }

    /**
     * 清理
     */
    private void doDestroy() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping(MyDirectController myDirectController){
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
        mapping.setUrlMap(Collections.singletonMap("/testMyDirectController", myDirectController));
        return mapping;
    }
}
