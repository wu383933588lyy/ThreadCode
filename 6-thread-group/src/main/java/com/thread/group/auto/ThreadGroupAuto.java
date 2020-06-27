package com.thread.group.auto;

/**
 * @ClassName ThreadGroupAuto
 * @Author WuRui
 * @Date 2020/6/27 9:48
 * @Version 1.0
 * @Description //TODO
 **/
public class ThreadGroupAuto {

    public static void main(String[] args) {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        System.out.println("所属线程组：" + Thread.currentThread().getThreadGroup().getName());
        System.out.println("线程组中有线程组数量：" + Thread.currentThread().getThreadGroup().activeGroupCount());
        // 没有指定线程组，那么自动归档到当前线程所属的线程组
        ThreadGroup group = new ThreadGroup("新的组");
        System.out.println("线程组中有线程组的数量：" + Thread.currentThread().getThreadGroup().activeGroupCount());
    }
}
