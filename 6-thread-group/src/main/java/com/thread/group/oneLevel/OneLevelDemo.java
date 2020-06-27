package com.thread.group.oneLevel;

/**
 * @ClassName OneLevelDemo
 * @Author WuRui
 * @Date 2020/6/27 10:06
 * @Version 1.0
 * @Description //TODO
 **/
public class OneLevelDemo {

    public static void main(String[] args) {
        TestThread testThread1 = new TestThread();
        TestThread testThread2 = new TestThread();
        ThreadGroup group = new ThreadGroup("新建线程组1");
        Thread thread1 = new Thread(group, testThread1);
        Thread thread2 = new Thread(group, testThread2);
        thread1.start();
        thread2.start();
        System.out.println("活动的线程数为：" + group.activeCount());
        System.out.println("线程组的名称：" + group.getName());
    }
}
