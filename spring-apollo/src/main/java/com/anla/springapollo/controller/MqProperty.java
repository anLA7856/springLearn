package com.anla.springapollo.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/12/14 16:38
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "alimq")
public class MqProperty {
    /**
     * topic
     */
    private String topic;
    private String orderTopic;
    /**
     * mqEnv
     */
    private String mqEnv;

    /**
     * accessKey
     */
    private String accessKey;
    /**
     * secretKey
     */
    private String secretKey;
    /**
     * onsAddr
     */
    private String onsAddr;
}
