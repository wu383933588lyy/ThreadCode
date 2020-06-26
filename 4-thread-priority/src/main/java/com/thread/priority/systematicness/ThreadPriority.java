package com.thread.priority.systematicness;

/**
 * @ClassName ThreadPriority
 * @Author WuRui
 * @Date 2020/6/26 10:00
 * @Version 1.0
 * @Description //TODO 线程规则性和随机性
 **/
public class ThreadPriority {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThread1 myThread1 = new MyThread1();
            myThread1.setPriority(1);
            MyThread2 myThread2 = new MyThread2();
            myThread2.setPriority(10);
            myThread1.start();
            myThread2.start();
        }
    }
}
