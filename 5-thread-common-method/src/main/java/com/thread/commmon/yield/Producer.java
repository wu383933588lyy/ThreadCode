package com.thread.commmon.yield;

/**
 * @ClassName Producer
 * @Author WuRui
 * @Date 2020/6/27 8:39
 * @Version 1.0
 * @Description //TODO
 **/
public class Producer extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("I am Producer : Producer Item " + i);
        }
    }
}
