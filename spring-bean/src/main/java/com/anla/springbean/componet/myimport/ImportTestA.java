package com.anla.springbean.componet.myimport;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/3/19 19:29
 **/
public class ImportTestA {
    public void fun(String str) {
        System.out.println(str);
    }

    public void printName() {
        System.out.println("类名 ：" + Thread.currentThread().getStackTrace()[1].getClassName());
    }
}
