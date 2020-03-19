package com.anla.springbean.componet.myimport;

/**
 * @author anLA7856
 * @date 20-3-19 下午10:42
 * @description
 */
public class ImportTestC {
    public void printName() {
        System.out.println(" ImportTestC 类名 ：" + Thread.currentThread().getStackTrace()[1].getClassName());
    }
}
