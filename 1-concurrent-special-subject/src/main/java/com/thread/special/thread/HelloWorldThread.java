package com.thread.special.thread;

/**
 * @ClassName HelloWorldThread
 * @Author WuRui
 * @Description //TODO 继承 Thread 类 创建线程
 * @Date 2020/6/25 10:02
 * @Version 1.0
 **/
public class HelloWorldThread extends Thread{

    @Override
    public void run() {
        System.out.println("Hello Concurrent World");
    }

    public static void main(String[] args) {
        System.out.println("----------创建线程---------");
        HelloWorldThread thread = new HelloWorldThread();
        System.out.println("----------启动线程---------");
        thread.start();
    }
}
