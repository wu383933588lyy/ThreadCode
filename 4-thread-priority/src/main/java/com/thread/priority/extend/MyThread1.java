package com.thread.priority.extend;

/**
 * @ClassName MyThread1
 * @Author WuRui
 * @Date 2020/6/26 9:32
 * @Version 1.0
 * @Description //TODO
 **/
public class MyThread1 extends Thread {
    @Override
    public void run() {
        super.run();
        // 输出线程级别
        System.out.println("MyThread1 Priority = " + this.getPriority());
        // 启动线程 MyThread2
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }
}
