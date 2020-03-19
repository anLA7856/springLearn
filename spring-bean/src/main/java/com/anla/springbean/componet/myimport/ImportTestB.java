package com.anla.springbean.componet.myimport;

/**
 * @author anLA7856
 * @date 20-3-19 下午10:31
 * @description
 */
public class ImportTestB {

    public void printName() {
        System.out.println(" ImportTestB类名 ：" + Thread.currentThread().getStackTrace()[1].getClassName());
    }
}
