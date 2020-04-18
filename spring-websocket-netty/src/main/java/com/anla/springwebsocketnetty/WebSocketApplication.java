package com.anla.springwebsocketnetty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yeauty.annotation.EnableWebSocket;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/4/15 12:46
 **/
@EnableWebSocket
@SpringBootApplication
public class WebSocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);
    }
}
