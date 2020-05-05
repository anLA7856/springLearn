package com.anla.springtransactionaspectJ.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 13:10
 **/
@Configuration
public class CommonConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource datasourceCustomer() {
        return DruidDataSourceBuilder.create().build();
    }


    /**
     * 定义声明式事务
     * @return
     */
    @Bean
    public DataSourceTransactionManager customerTransactionManager() {
        return new DataSourceTransactionManager(datasourceCustomer());
    }
}
