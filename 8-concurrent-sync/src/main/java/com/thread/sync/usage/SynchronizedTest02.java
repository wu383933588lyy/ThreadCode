package com.thread.sync.usage;

import ch.qos.logback.core.util.TimeUtil;

/**
 * @ClassName SynchronizedTest02
 * @Author WuRui
 * @Date 2020/6/27 19:54
 * @Version 1.0
 * @Description: 一个线程获取了该对象的锁之后，其他线程来访问其他 synchronized 实例方法现象
 * 可以看出其他线程来访问 synchronized 修饰的其他方法时需要等到线程1 先把锁释放
 **/
public class SynchronizedTest02 {

    /**
     * 同步方法
     */
    public synchronized void method1() {
        System.out.println("Method 1 started : " + System.currentTimeMillis());
        try {
            System.out.println("Method 1 executed : " + System.currentTimeMillis());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 ended : " + System.currentTimeMillis());
    }

    public synchronized void method2() {
        System.out.println("Method 2 started : " + System.currentTimeMillis());
        try {
            System.out.println("Method 2 executed : " + System.currentTimeMillis());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 ended : " + System.currentTimeMillis());
    }

    public static void main(String[] args) {
        final SynchronizedTest02 test02 = new SynchronizedTest02();
        new Thread(test02::method1).start();
        new Thread(test02::method2).start();

    }
}

