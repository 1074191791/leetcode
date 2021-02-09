package com.zhou.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhous
 * @version 1.0
 * @date 2021/1/13 20:34
 */
public class AtomicTestDemo {

    public static void main(String[] args) {

        MyThread2 m2 = new MyThread2();

        for (int i = 0; i < 10; i++) {
            new Thread(m2).start();
        }
    }
}

class MyThread2 implements Runnable{

    private AtomicInteger serialNum = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(serialNum.getAndAdd(1));
    }
}
