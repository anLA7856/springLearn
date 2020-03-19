package com.anla.springbean.componet.myimport;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/3/19 19:27
 **/
@Import({ImportTestA.class, ImportSelectorTest.class, ImportBeanDefinitionRegistrarTest.class})
@Configuration
public class MyMainImporter {
}
