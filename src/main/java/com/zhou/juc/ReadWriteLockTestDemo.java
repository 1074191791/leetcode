package com.zhou.juc;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhous
 * @version 1.0
 * @date 2021/1/18 16:36
 */
public class ReadWriteLockTestDemo {

    public static void main(String[] args) {
        ReadWirteLockDemo readWirteLockDemo = new ReadWirteLockDemo();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readWirteLockDemo.increaseI();
                }
            }).start();
        }
    }
}

class ReadWirteLockDemo {

    Integer i = 1;

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public int getI() {
        readWriteLock.readLock().lock();
        try{
            return i;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void increaseI() {
        readWriteLock.writeLock().lock();

        try {
            Thread.sleep(new Random().nextInt(100));
            i++;
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }
}