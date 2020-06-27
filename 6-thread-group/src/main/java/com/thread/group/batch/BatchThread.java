package com.thread.group.batch;

/**
 * @ClassName BatchThread
 * @Author WuRui
 * @Date 2020/6/27 9:55
 * @Version 1.0
 * @Description //TODO
 **/
public class BatchThread extends Thread {

    public BatchThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        System.out.println("ThreadName = " + Thread.currentThread().getName() + "开始死循环");
        while (!this.isInterrupted()) {

        }
        System.out.println("ThreadName = " + Thread.currentThread().getName() + "结束了");

    }
}
