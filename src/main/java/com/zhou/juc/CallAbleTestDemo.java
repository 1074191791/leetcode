package com.zhou.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhous
 * @version 1.0
 * @date 2021/1/13 22:28
 */
public class CallAbleTestDemo {

    public static void main(String[] args) {
        MyTrhead4 myTrhead4 = new MyTrhead4();
        FutureTask<Integer> futureTask1 = new FutureTask<>(myTrhead4);
        FutureTask<Integer> futureTask2 = new FutureTask<>(myTrhead4);

        new Thread(futureTask1, "A").start();
        new Thread(futureTask2, "B").start();

        try {
            //获取返回值
            Integer integer = futureTask1.get();
            //让子线程先跑完，但是子线程跑的过程中主线程并不会跑，子线程跑完主线程才跑，
            //节点是在调用get()方法的时候， 类似于 countDownLatch.await()方法;
            System.out.println("==========================");
            System.out.println(integer);
            Integer integer1 = futureTask2.get();
            System.out.println("==========================");
            System.out.println(integer1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class MyTrhead4 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            sum += i;
        }
        return sum;
    }
}
