package com.thread.special.runnable;

/**
 * @ClassName HelloWorldRunnable
 * @Author WuRui
 * @Description //TODO Runnable接口创建线程
 * @Date 2020/6/25 9:55
 * @Version 1.0
 **/
public class HelloWorldRunnable implements Runnable{


    @Override
    public void run() {
        System.out.println("Hello Concurrent World");
    }

    public static void main(String[] args) {
        System.out.println("---------------实现 Runnable 接口------------------");
        HelloWorldRunnable runnable = new HelloWorldRunnable();
        System.out.println("---------------创建线程----------------------------");
        Thread thread = new Thread(runnable);
        System.out.println("---------------启动线程----------------------------");
        thread.start();
    }
}
