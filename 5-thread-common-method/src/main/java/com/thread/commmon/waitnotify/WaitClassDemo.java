package com.thread.commmon.waitnotify;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName WaitClassDemo
 * @Author WuRui
 * @Date 2020/6/26 10:20
 * @Version 1.0
 * @Description //TODO
 **/
public class WaitClassDemo {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        Object o = new Object();
        for (int i = 0; i < 5; i++) {
            new WaitThread(i + "", o).start();
        }
        new NotifyThread(o).start();
    }

    /**
     * 调用 wait() 方法的线程
     */
    static class WaitThread extends Thread {
        Object object;

        public WaitThread(String name, Object object) {
            setName("WaitThread" + name);
            this.object = object;
        }

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(simpleDateFormat.format(new Date()) + " " + getName() + " before wait()");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(simpleDateFormat.format(new Date()) + " " + getName() + " after wait()");
            }
        }
    }

    /**
     * 调用 notify() notifyAll
     */
    static class NotifyThread extends Thread {

        Object object;

        public NotifyThread(Object object) {
            setName("NotifyThread");
            this.object = object;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                System.out.println(simpleDateFormat.format(new Date()) + " " + getName() + " before wait()");
                // 唤醒所有线程 用notifyAll()会按照后进先出（LIFO）的原则恢复线程
                object.notifyAll();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(simpleDateFormat.format(new Date()) + " " + getName() + " after wait()");
            }
        }
    }
}
