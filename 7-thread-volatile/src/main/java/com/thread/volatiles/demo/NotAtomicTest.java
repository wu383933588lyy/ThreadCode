package com.thread.volatiles.demo;

/**
 * @ClassName NotAtomicTest
 * @Author WuRui
 * @Date 2020/6/27 15:22
 * @Version 1.0
 * @Description //TODO
 **/
public class NotAtomicTest {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final NotAtomicTest test = new NotAtomicTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increase();
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(test.inc);
    }
}
