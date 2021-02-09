package com.zhou.juc;

import cn.hutool.core.thread.ThreadUtil;
import com.sun.jndi.ldap.pool.Pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/**
 * @author zhous
 * @version 1.0
 * @date 2021/2/2 18:12
 */
public class TimeOutTestDemo {




    public static void main(String[] args) {
        ExecutorService executorService = ThreadUtil.newExecutor();


        FutureTask<Boolean> futureTask = new FutureTask<Boolean>(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + i);
                }

                return Boolean.TRUE;
            }
        });
        executorService.submit(futureTask);

        try {
            Boolean aBoolean = futureTask.get();
            System.out.println(aBoolean);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("完事");
        executorService.shutdown();
    }
}
