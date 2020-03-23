package com.anla.springbean.componet.myimport;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/3/20 15:10
 **/
public class ImportTestG {
    public void printName() {
        System.out.println(" ImportTestG 类名 ：" + Thread.currentThread().getStackTrace()[1].getClassName());
    }
}
