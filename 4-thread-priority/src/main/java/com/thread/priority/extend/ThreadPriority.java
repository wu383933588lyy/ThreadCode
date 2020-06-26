package com.thread.priority.extend;

/**
 * @ClassName ThreadPriority
 * @Author WuRui
 * @Date 2020/6/26 9:36
 * @Version 1.0
 * @Description //TODO 线程优先级的继承特性 Demo
 **/
public class ThreadPriority {

    public static void main(String[] args) {
        System.out.println("1. Main Thread Priority = " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(10);
        System.out.println("2. Main Thread Priority = " + Thread.currentThread().getPriority());
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }
}
