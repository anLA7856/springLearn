package com.anla.springbean.componet;

import org.springframework.context.annotation.ComponentScan;

/**
 * ComponentScan 默认取扫描当前目录以下所有，然后合适的有注解的才会归入spring bean 容器管理。
 *
 *
 * @MyMainImporter 不能放到这上面，因为它不是component，所以不会被ConfigurationBeanPostProcessor 解析到。
 * @author luoan
 * @version 1.0
 * @date 2020/2/24 13:27
 **/
@ComponentScan
public class TestComponentScan {


}
