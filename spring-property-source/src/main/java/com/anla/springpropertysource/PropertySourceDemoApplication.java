package com.anla.springpropertysource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 答案是会
 * 定义多个同名配置，会覆盖吗？答案是不一定，看具体逻辑，Spring 中PropertySource有多个，有优先级的，所以可能是获取到了优先级更高配置类中的配置。但是使用 `@Value` 注解是，会被覆盖
 *
 * @author luoan
 * @version 1.0
 * @date 2020/10/30 13:43
 **/

@SpringBootApplication
@Slf4j
public class PropertySourceDemoApplication implements ApplicationRunner {
    @Value("${anla.greeting}")
    private String greeting;

    public static void main(String[] args) {
        SpringApplication.run(PropertySourceDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("{}", greeting);
    }
}