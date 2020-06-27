package com.thread.commmon.yield;

/**
 * @ClassName Consumer
 * @Author WuRui
 * @Date 2020/6/27 8:37
 * @Version 1.0
 * @Description //TODO
 **/
public class Consumer extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("I am Consumer: Consumer Item " + i);
            Thread.yield();
        }
    }
}
