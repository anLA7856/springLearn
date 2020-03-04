package com.anla.springbean.componet;

import com.anla.springbean.componet.primary.BasePeople;
import com.anla.springbean.componet.primary.Boy;
import com.anla.springbean.componet.primary.Girl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/3/4 13:35
 **/
@Configuration
public class CommonMethodBeanConfiguration {

    @Primary
    @Bean
    public BasePeople boy(){
        return new Boy();
    }

    @Bean
    public BasePeople girl(){
        return new Girl();
    }
}
