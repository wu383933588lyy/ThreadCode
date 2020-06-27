package com.thread.sync.usage;

/**
 * @ClassName SynchronizedTest01
 * @Author WuRui
 * @Date 2020/6/27 15:28
 * @Version 1.0
 * @Description //TODO 多个线程访问同一个对象的同一个方法
 * <p>
 * 两个线程同时对一个对象的一个方法进行操作，只有一个线程能够抢到锁。
 * 因为一个对象只有一把锁，一个线程获取了该对象的锁之后，其他线程无法获取对的锁。
 * 就不能访问该对象的其他 synchronized 方法，但是可以访问非 synchronized 修饰的方法。
 **/
public class SynchronizedTest01 implements Runnable {

    /**
     * 共享资源
     **/
    static int counter = 0;

    /**
     * synchronized 修饰的实例方法
     **/
    public synchronized void increase() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "执行累加操作 ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
    }

    @Override
    public void run() {
        increase();
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest01 test01 = new SynchronizedTest01();
        Thread thread1 = new Thread(test01, "线程1");
        Thread thread2 = new Thread(test01, "线程2");
        thread1.start();
        thread2.start();
        // 主线程等待 线程1 和 线程2 执行结束
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }
}
