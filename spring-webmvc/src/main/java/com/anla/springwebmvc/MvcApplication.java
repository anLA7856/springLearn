package com.anla.springwebmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 16:26
 **/
@ServletComponentScan("com.anla.springwebmvc.servlet")
@SpringBootApplication
public class MvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }
}
