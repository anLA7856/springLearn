package com.anla.springtransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 1. 如果使用aspectj模式，则需要加上@EnableLoadTimeWeaving 以及制定agent。（或者配置）目前项目就是这样
 * 2. 如果不使用aspectj模式，则mode使用默认的proxy即可，这样调试也舒服些。
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 13:09
 **/
@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
//@EnableLoadTimeWeaving
public class TransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }
}
