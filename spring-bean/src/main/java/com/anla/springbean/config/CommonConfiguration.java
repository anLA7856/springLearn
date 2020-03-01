package com.anla.springbean.config;

import com.anla.springbean.model.Dog;
import org.springframework.context.annotation.Bean;

/**
 * @author anLA7856
 * @date 20-1-12 下午10:42
 * @description
 */
public class CommonConfiguration {

    @Bean
    public Dog dog(){
        return new Dog();
    }
}
