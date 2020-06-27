package com.thread.group.levels;

import com.thread.group.oneLevel.TestThread;

/**
 * @ClassName LevelsDemo
 * @Author WuRui
 * @Date 2020/6/27 10:01
 * @Version 1.0
 * @Description //TODO
 **/
public class LevelsDemo {

    public static void main(String[] args) {
        ThreadGroup group1 = new ThreadGroup("线程组1");
        ThreadGroup group2 = new ThreadGroup(group1, "线程组2");
        ThreadGroup group3 = new ThreadGroup(group1, "线程组3");
        TestThread testThread1 = new TestThread();
        TestThread testThread2 = new TestThread();
        TestThread testThread3 = new TestThread();
        Thread thread1 = new Thread(group1, testThread1);
        Thread thread2 = new Thread(group2, testThread2);
        Thread thread3 = new Thread(group3, testThread3);
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("threadGroup1线程组的名称为：" + group1.getName());
        System.out.println("threadGroup1活动的线程数为：" + group1.activeCount());
        System.out.println("threadGroup1活动的线程组数为：" + group1.activeGroupCount());
        System.out.println("threadGroup2线程组的名称为：" + group2.getName());
        System.out.println("threadGroup2活动的线程数为：" + group2.activeCount());
        System.out.println("threadGroup3线程组的名称为：" + group3.getName());
        System.out.println("threadGroup3活动的线程数为：" + group3.activeCount());
    }
}
