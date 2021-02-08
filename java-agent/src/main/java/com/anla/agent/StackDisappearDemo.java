package com.anla.agent;

/**
 * 有错误也返回
 * @author luoan
 * @version 1.0
 * @date 2021/2/8 11:12
 **/
public class StackDisappearDemo {
    public static void main(String[] args) {
//  SpringApplication.run(DemoApplication.class, args);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println("times:" + i + " , result:" + testExceptionTrunc());
        }
    }

    public static boolean testExceptionTrunc()  {
        try {
            // 人工构造异常抛出的场景
            ((Object)null).getClass();
        } catch (Exception e) {
            // debug 不会走到这一步
            if (e.getStackTrace().length == 0) {
                try {
                    // 堆栈消失的时候当前线程休眠5秒，便于观察
                    Thread.sleep(5000);
                } catch (InterruptedException interruptedException) {
                    // do nothing
                }
                return true;
            }
        }
        return false;
    }
}
