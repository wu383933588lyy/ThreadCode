package com.thread.priority.extend;

/**
 * @ClassName MyThread2
 * @Author WuRui
 * @Date 2020/6/26 9:34
 * @Version 1.0
 * @Description //TODO
 **/
public class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread2 priority = " + this.getPriority());
    }
}
