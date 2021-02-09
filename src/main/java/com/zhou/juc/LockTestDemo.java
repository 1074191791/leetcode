package com.zhou.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhous
 * @version 1.0
 * @date 2021/1/14 19:04
 */
public class LockTestDemo {


    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        Thread seller1 = new Thread(sellTicket);
        Thread seller2 = new Thread(sellTicket);
        Thread seller3 = new Thread(sellTicket);

        seller1.start();
        seller2.start();
        seller3.start();


    }
}

class SellTicket implements Runnable {

    private Integer ticket = 100;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            //synchronized (SellTicket.class) {
            lock.lock();
                try {

                    if (ticket > 0) {
                        sellOneTicket();
                    } else {
                        break;
                    }
                } finally {
                    lock.unlock();
                }

            //}
        }
    }

    public void sellOneTicket() {
        ticket--;
        System.out.println(Thread.currentThread().getName() + "窗口卖出第 " + ticket + "张票");
        //卖完票之后歇一歇
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

}