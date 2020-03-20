package com.anla.springtransaction;

import com.anla.springtransaction.springspi.SpringSpiBeanTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 13:09
 **/
@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
public class TransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }
}
