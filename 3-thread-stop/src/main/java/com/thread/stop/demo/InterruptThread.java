package com.thread.stop.demo;

/**
 * @ClassName InterruptThread
 * @Author WuRui
 * @Date 2020/6/25 19:23
 * @Version 1.0
 * @Description //TODO
 **/
public class InterruptThread extends Thread{

    /** 退出标识 **/
    volatile boolean exit = false;

    @Override
    public void run() {
        while (!exit){
            System.out.println(getName()+"is running ...");
            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                System.out.println("week up from block ...");
                exit = true;
            }
        }
        System.out.println(getName() + "is exiting ...");
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptThread interruptThread = new InterruptThread();
        System.out.println("starting thread ...");
        interruptThread.start();
        Thread.sleep(3000);
        System.out.println("Interrupt thread ..." + interruptThread.getName());
        // 设置退出标识为 true
        interruptThread.exit = true;
        // 阻塞时退出阻塞状态
        interruptThread.interrupt();
        // 主线程休眠 3 秒，观察线程interruptThread的中断情况
        Thread.sleep(3000);
        System.out.println("Stopping application ...");
    }
}
