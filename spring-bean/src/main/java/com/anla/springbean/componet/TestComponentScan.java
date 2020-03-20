package com.anla.springbean.componet;

import com.anla.springbean.componet.myimport.MyMainImporter;
import org.springframework.context.annotation.ComponentScan;

/**
 * ComponentScan 默认取扫描当前目录以下所有，然后合适的有注解的才会归入spring bean 容器管理。
 * @author luoan
 * @version 1.0
 * @date 2020/2/24 13:27
 **/
// @MyMainImporter
@ComponentScan
public class TestComponentScan {


}
