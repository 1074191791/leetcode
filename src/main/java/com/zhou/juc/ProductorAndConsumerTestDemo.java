//package com.zhou.juc;
//
///**
// * 生产者消费者问题
// *
// * 生产者 生产产品 ——》 店员  --》 消费者 消费产品
// * @author zhous
// * @version 1.0
// * @date 2021/1/14 20:25
// */
//public class ProductorAndConsumerTestDemo {
//
//    public static void main(String[] args) {
//        Shop shop = new Shop();
//        Producter producter = new Producter(shop);
//        Consumer consumer = new Consumer(shop);
//        // 生产消费要等量昂，否则会有无货可卖死等， 或者无需进货死等， 可以指定wait时间进行释放，但因为死循环了，所以还是释放不了嘞
//        new Thread(producter, "生产者A").start();
//        new Thread(producter, "生产者B").start();
//        new Thread(producter, "生产者C").start();
//        new Thread(consumer, "消费者A").start();
//        new Thread(consumer, "消费者B").start();
//        new Thread(consumer, "消费者C").start();
//        //new Thread(consumer, "消费者D").start();
//
//    }
//}
//
///**
// * 商店
// */
//class Shop {
//    /**
//     * 库存
//     */
//    private int stock = 0;
//
//    /**
//     * 进货
//     */
//    public synchronized void getStock() {
//        //这里把库存调小到1个
//        while (stock >= 1) {
//            System.out.println("库存已满，无需进货");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            // 随机数睡眠，看谁能抢到
//            try {
//                Thread.sleep((long) (Math.random()*10));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        //这里去掉else,
//        System.out.println("店员"+Thread.currentThread().getName()+"进货 ，库存+1后， 库存量： "+ ++stock);
//        this.notifyAll();
//
//    }
//
//    /**
//     * 卖货
//     */
//    public synchronized void sellStock() {
//        while (stock < 1) {
//            System.out.println("库存量： "+stock + "， 无货可卖了");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("店员"+Thread.currentThread().getName()+"购买一件商品， 商品库存量"+ --stock);
//        this.notifyAll();
//
//    }
//}
//
//class Producter implements Runnable {
//    private Shop shop;
//
//    public Producter( Shop shop) {
//        this.shop = shop;
//    }
//
//    /**
//     * 生产商品，
//     */
//    public void constructProduct() {
//        shop.getStock();;
//
//    }
//
//    @Override
//    public void run() {
//
//        for (int i = 0; i < 20; i++) {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            constructProduct();
//        }
//    }
//}
//
//class Consumer implements Runnable {
//    private Shop shop;
//
//    public Consumer(Shop shop) {
//        this.shop = shop;
//    }
//
//    public void buyProduct() {
//        shop.sellStock();
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 20; i++) {
//            buyProduct();
//        }
//    }
//}