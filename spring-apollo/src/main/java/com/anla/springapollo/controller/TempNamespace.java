package com.anla.springapollo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/12/17 15:57
 **/
@Data
@Configuration
@ConfigurationProperties("spring.cloud.apollo.my")
public class TempNamespace {

    private List<TempNamespaceProperty> namespaces = new ArrayList<>();

    @Data
    static class TempNamespaceProperty {

        private String name;
        private boolean refreshable = true;
    }

}
