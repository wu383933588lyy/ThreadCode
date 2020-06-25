package com.thread.interruption.demo;

/**
 * @ClassName RethrowInterrupterException
 * @Author WuRui
 * @Date 2020/6/25 15:59
 * @Version 1.0
 * @Description //TODO 捕获异常并重新抛出
 **/
public class RethrowInterrupterException {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        try {
            thread.interrupt();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("做一些清理工作");
            throw e;
        }
    }
}
