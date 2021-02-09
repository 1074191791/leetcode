package com.zhou.juc;

/**
 * @author zhous
 * @version 1.0
 * @date 2021/1/18 15:30
 */
public class ThreadEightLock {

    private static NumberSout numberSout = new NumberSout();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                NumberSout.soutA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                NumberSout.soutB();
            }
        }).start();

    }

}

class NumberSout {

    public static synchronized void soutA() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A");
    }


    public static synchronized void soutB() {
        System.out.println("B");
    }

    public void soutC() {
        System.out.println("C");
    }
}
