package com.anla.springloadtimeweaver;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import static org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving.AUTODETECT;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/4/27 13:14
 **/
@Configuration
@EnableLoadTimeWeaving(aspectjWeaving=AUTODETECT)
@ComponentScan
public class CustomerLoadTimeWeaverConfig {
}
