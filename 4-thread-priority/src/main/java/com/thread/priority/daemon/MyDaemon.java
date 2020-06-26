package com.thread.priority.daemon;

/**
 * @ClassName MyDaemon
 * @Author WuRui
 * @Date 2020/6/26 9:03
 * @Version 1.0
 * @Description //TODO
 **/
public class MyDaemon implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 99999; i++) {
            System.out.println("守护线程第" + i + "次执行");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
