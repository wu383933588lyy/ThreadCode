package com.thread.group.oneLevel;

/**
 * @ClassName TestThread
 * @Author WuRui
 * @Date 2020/6/27 10:04
 * @Version 1.0
 * @Description //TODO
 **/
public class TestThread implements Runnable {

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("ThreadName = " + Thread.currentThread().getName());
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
