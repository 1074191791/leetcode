package com.zhou.juc;

/**
 * volatile关键字修改内存可见性为主缓存，
 *
 * @author zhous
 * @version 1.0
 * @date 2021/1/13 19:43
 */
public class VolatileTestDemo {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread).start();

        while (true) {
            if(myThread.getFlag()) {
                System.out.println("=======================");
                break;
            }
        }
    }

}

class MyThread implements Runnable{

    //private Boolean flag = false;
    private Boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        this.setFlag(Boolean.TRUE);
        System.out.println("this.getFlag() = " + this.getFlag());
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
