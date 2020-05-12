package com.anla.springwebmvc.servlet;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/12 15:51
 **/
public class Deadlock2
{
    public static void main(String arg[]) throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


        Thread threadPark = new Thread(new Runnable() {
            @Override
            public void run() {

                Lock readLock = lock.readLock();
                readLock.lock();
                try {
                    while (true){
                        System.out.println("I have the read lock!! But I wan not to give it you");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }finally {
                    readLock.unlock();
                }
            }
        });

/*        Thread threadWrite = new Thread(new Runnable() {
            @Override
            public void run() {
                Lock writeLock = lock.writeLock();
                writeLock.lock();
                try {
                    System.out.println("I have the write lock!!!!");
                }finally {
                    writeLock.unlock();
                }
            }
        });*/

        Thread threadRead = new Thread(new Runnable() {
            @Override
            public void run() {
                Lock readLock = lock.readLock();
                readLock.lock();
                try {
                    System.out.println("I have the read lock!!!!");
                }finally {
                    readLock.unlock();
                }
            }
        });

        threadPark.start();
        Thread.sleep(2000);
//        threadWrite.start();
//        Thread.sleep(2000);
        threadRead.start();

    }

}