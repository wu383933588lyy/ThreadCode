package com.thread.interruption.demo;

/**
 * @ClassName ReInterrupt
 * @Author WuRui
 * @Date 2020/6/25 15:47
 * @Version 1.0
 * @Description //TODO 重新中断
 **/
public class ReInterrupt extends Thread {

    @Override
    public void run() {
        // 循环等待线程中断
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Thread running ...");
            try {
                // 线程阻塞，如果线程手动中断操作信号，将抛出异常
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted ...");
                System.out.println(this.isInterrupted());
                // 是否线程中断由自己决定，如果需要真的中断线程，这需要重新设置中断位
                // 如果不需要，则不用中断
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("reInterrupt..."+this.isInterrupted());
        System.out.println("Thread exiting...");
    }

    public static void main(String[] args) throws InterruptedException {
        ReInterrupt reInterrupt = new ReInterrupt();
        System.out.println("Starting thread ...");
        // 启动新线程
        reInterrupt.start();
        // 主线程休眠 3 秒
        Thread.sleep(3000);
        System.out.println("Asking thread to stop...");
        // 设置线程中断
        reInterrupt.interrupt();
        // 主线程休眠 3 秒
        Thread.sleep(3000);
        System.out.println("Stopping application ...");
    }
}
