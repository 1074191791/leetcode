package com.zhou.juc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
 *
 * @author zhous
 * @version 1.0
 * @date 2021/1/18 16:54
 */
public class ThreadPoolTestDemo {

    public static void main(String[] args) {
        //ExecutorService pool = ThreadUtil.newExecutor();

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(6);

        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "abc");
            }
        }, 5, TimeUnit.SECONDS);

        pool.shutdown();
    }

}


