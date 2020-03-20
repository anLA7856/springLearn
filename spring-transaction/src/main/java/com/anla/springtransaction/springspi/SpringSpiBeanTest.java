package com.anla.springtransaction.springspi;

/**
 * 测试通过Spring spi 方式引入
 * @author luoan
 * @version 1.0
 * @date 2020/3/20 13:39
 **/
public class SpringSpiBeanTest {
    public SpringSpiBeanTest() {
    }

    public void printName(){
        System.out.println("hello, I am from Spring SPI");
    }
}
