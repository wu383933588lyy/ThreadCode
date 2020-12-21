package com.demo;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName ThreadLocalDemo
 * @Author WuRui
 * @Date 2020/12/20 16:02
 * @Version 1.0
 * @Description //TODO ThreadLocal 使用方式
 * 从运行结果可以看出，每个线程第一次调用ThreadLocal对象的get方法时都得到初始值3，注意我们上面的代码是让三个线程顺序执行
 * 显然从运行结果看，第一个线程结束后设置的新值，对第二个线程是没有影响的
 * 第二个线程完成后设置的新值对第三个线程也没有影响。
 * 这就仿佛把ThreadLocal对象当做每个线程内部的对象一样，但实际上threadLocal对象是个外部类对象，
 * 内部类Worker访问到的是同一个threadLocal对象，也就是说是被各个线程共享的。这是如何做到的呢？我们就来看看ThreadLocal对象的内部原理。
 **/
public class ThreadLocalDemo {

    /**
     * 定义了一个 ThreadLocal<Integer> 对象
     * 并重写它的 initialValue 方法，初始值为 3
     * 这个对象会在三个线程间共享。
     */
    private ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 3);

    /**
     * 设置一个信号量，许可数为 1，让这三个线程顺序执行。
     */
    private Semaphore semaphore = new Semaphore(1);

    /**
     * 一个随机数
     */
    private Random random = new Random();

    public class Worker implements Runnable{

        @Override
        public void run() {
            try {
                // 随机休眠 1s 以内的时间
                Thread.sleep(random.nextInt(1000));
                // 获得许可
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 从 threadLocal 中获取值
            Integer val = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "threadLocal old value  = "+val);
            // 修改 val 值，并放入 threadLocal 中
            val = random.nextInt();
            threadLocal.set(val);
            System.out.println(Thread.currentThread().getName() + " threadLocal new value: " + val);
            System.out.println(Thread.currentThread().getName() + " threadLocal latest value : " + threadLocal.get());
            // 释放信号量
            semaphore.release();
            // 在线程池中，当线程退出之前一定要记得调用 remove() 方法，因为线程池中的线程对象是循环使用的。
            threadLocal.remove();
        }
    }

    /**
     * //TODO 创建三个线程，每个线程都会对 ThreadLocal 对象进行操作
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        ThreadLocalDemo demo = new ThreadLocalDemo();
        service.execute(demo.new Worker());
        service.execute(demo.new Worker());
        service.execute(demo.new Worker());
        service.shutdown();
    }
}