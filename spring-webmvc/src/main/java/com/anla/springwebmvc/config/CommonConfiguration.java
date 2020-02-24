package com.anla.springwebmvc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

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
}
