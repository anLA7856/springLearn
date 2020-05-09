package com.anla.springwebmvc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * kill 时 hook
 * @author luoan
 * @version 1.0
 * @date 2020/2/21 11:04
 **/
@Slf4j
@ConfigurationProperties(prefix = "anla")
@Component
public class TestConfig {

    private String msg;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
