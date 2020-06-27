package com.thread.commmon.join;

/**
 * @ClassName JoinDemo
 * @Author WuRui
 * @Date 2020/6/27 8:28
 * @Version 1.0
 * @Description //TODO
 **/
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 started");
            System.out.println("thread2 sleeping for 2 seconds");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2 completed");
        });


        Thread thread1 = new Thread(() -> {
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 started");
            System.out.println("thread1 sleeping for 2 seconds");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 completed");
        });

        // 线程1 启动
        thread1.start();
//        thread1.join();
        thread2.start();

    }


}
