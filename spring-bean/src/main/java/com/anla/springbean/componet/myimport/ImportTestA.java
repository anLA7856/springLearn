package com.anla.springbean.componet.myimport;

/**
 * 普通类，会直接加入到 Spring 容器中，由ConfigurationClassPostProcessor
 * @author luoan
 * @version 1.0
 * @date 2020/3/19 19:29
 **/
public class ImportTestA {

    public ImportTestA() {

    }

    public void printName() {
        System.out.println("类名 ：" + Thread.currentThread().getStackTrace()[1].getClassName());
    }
}
