package com.zhou.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhous
 * @version 1.0
 * @date 2021/1/13 22:16
 */
public class CountDownLatchTestDemo {

    public static void main(String[] args) {
        long start = System.nanoTime();
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread3(countDownLatch)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
        }
        System.out.println("花费时间:" + (System.nanoTime() - start));

    }
}

class MyThread3 implements Runnable{

    private CountDownLatch countDownLatch;

    public MyThread3(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        countDownLatch.countDown();
    }
}
