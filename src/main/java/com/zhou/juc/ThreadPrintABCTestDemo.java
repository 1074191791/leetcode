package com.zhou.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhous
 * @version 1.0
 * @date 2021/1/14 22:21
 */
public class ThreadPrintABCTestDemo {


    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                printABC.printA(i);
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                printABC.printB(i);
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                printABC.printC(i);
            }
        }, "C").start();


    }
}

class PrintABC {

    int flag = 1;

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printA(int loopTimes) {
        lock.lock();
        try {
            while (flag != 1) {
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "loopTime" + ++loopTimes);
            flag = 2;
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void printB(int loopTimes) {
        lock.lock();
        try {
            while (flag != 2) {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "loopTime" + ++loopTimes);
            flag = 3;
            condition3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void printC(int loopTimes) {
        lock.lock();
        try {
            while (flag != 3) {
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "loopTime" + ++loopTimes);
            flag = 1;
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }
}

