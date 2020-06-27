package com.thread.special.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName HelloWorldCallable
 * @Author WuRui
 * @Description //TODO FutureTask : 接收返回值的线程
 * @Date 2020/6/25 9:48
 * @Version 1.0
 **/
public class HelloWorldCallable {

    public static void main(String[] args) {
        FutureTask task = new FutureTask(() -> {
            int count = 0;
            for (int i = 0; i < 100; i++) {
                count += i;
            }
            return count;
        });

        Thread thread = new Thread(task);
        thread.start();
        try {
            // 获取线程返回的值
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
