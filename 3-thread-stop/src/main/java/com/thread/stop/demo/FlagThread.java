package com.thread.stop.demo;

/**
 * @ClassName FlagThread
 * @Author WuRui
 * @Date 2020/6/25 19:15
 * @Version 1.0
 * @Description //TODO 设置退出标识
 **/
public class FlagThread extends Thread{

    /** 退出标识 **/
    public volatile boolean exit = false;

    @Override
    public void run() {
        while (!exit);
        System.out.println("FlagThread 线程退出");
    }

    public static void main(String[] args) throws InterruptedException {
        FlagThread flagThread = new FlagThread();
        flagThread.start();
        // 主线程延迟 3 秒
        Thread.sleep(3000);
        // 终止线程 thread
        flagThread.exit = true;
        // main 线程放弃 cpu 使用权
        // 让 flagThread 线程继续执行，直到 flagThread 运行完成
        flagThread.join();
        System.out.println("线程退出");
    }
}
