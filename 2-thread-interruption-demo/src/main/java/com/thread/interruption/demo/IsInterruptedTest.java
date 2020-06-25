package com.thread.interruption.demo;

/**
 * @ClassName IsInterruptedTest
 * @Author WuRui
 * @Date 2020/6/25 15:41
 * @Version 1.0
 * @Description //TODO
 * 1. isInterrupted() 检测调用该方法的线程是否被中断，中断状态 不会被清除。
 * 2. 线程一旦被中断，该方法返回 true
 * 3. 一旦 sleep() 等方法响应中断，抛出中断异常，将清除中断状态，此时方法将返回 false
 **/
public class IsInterruptedTest {

    public static void main(String[] args) {
        // 当前线程
        Thread thread = Thread.currentThread();
        // 当前线程是否被中断
        System.out.println("1==" + thread.isInterrupted());
        // 设置中断表示
        thread.interrupt();
        // 判断线程是否被中断
        System.out.println("2=="+thread.isInterrupted());
        // 判断线程是否被中断
        System.out.println("3=="+thread.isInterrupted());
        try {
            Thread.sleep(2000);
            System.out.println("not interrupted ....");
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep interrupted ...");
            // 判断线程是否被中断
            System.out.println("4=="+thread.isInterrupted());
        }
        // 判断线程是否被中断
        System.out.println("5=="+thread.isInterrupted());
    }
}
