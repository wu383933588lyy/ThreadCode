package com.thread.priority.systematicness;

import java.util.Random;

/**
 * @ClassName MyThread2
 * @Author WuRui
 * @Date 2020/6/26 9:59
 * @Version 1.0
 * @Description //TODO
 **/
public class MyThread2 extends Thread {

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        System.out.println("---2--- thread1 start running ...");
        long count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50000; j++) {
                Random random = new Random();
                random.nextInt();
                count = count + i;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("---2--- thread1 use time = " + (end - start));
    }
}
