package com.anla.springwebmvc.servlet;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/12 15:51
 **/
public class StampedLock1
{
    public static void main(String arg[]) throws InterruptedException {
        // fair和unfair 都不符合
        StampedLock lock = new StampedLock();
        Thread threadPark = new Thread(() -> {
            long stamp = lock.tryOptimisticRead();
            if(lock.validate(stamp)){
                while (true){
                    System.out.println("I have the read lock!! But I wan not to give it you");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadWrite = new Thread(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println("I have the write lock!!!!");
            }finally {
                lock.unlockWrite(stamp);
            }
        });
        Thread threadRead = new Thread(() -> {
            long stamp = lock.tryOptimisticRead();
            if (lock.validate(stamp)){
                System.out.println("I have the read lock!!!!");
            }
        });
        threadPark.start();
        Thread.sleep(2000);
        // threadWrite.start();
        Thread.sleep(2000);
        threadRead.start();
    }

}