package com.thread.commmon.yield;

/**
 * @ClassName YieldDemo
 * @Author WuRui
 * @Date 2020/6/27 8:39
 * @Version 1.0
 * @Description //TODO
 **/
public class YieldDemo {

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        // 设置优先级
        producer.setPriority(Thread.MIN_PRIORITY);
        consumer.setPriority(Thread.MAX_PRIORITY);
        consumer.start();
        producer.start();
    }
}
