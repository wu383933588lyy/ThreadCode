package com.thread.group.batch;

/**
 * @ClassName ThreadGroupBatchDemo
 * @Author WuRui
 * @Date 2020/6/27 9:57
 * @Version 1.0
 * @Description //TODO
 **/
public class ThreadGroupBatchDemo {

    public static void main(String[] args) {
        int batch = 5;
        ThreadGroup group = new ThreadGroup("我的线程组");
        for (int i = 0; i < batch; i++) {
            BatchThread batchThread = new BatchThread(group, "线程" + i);
            batchThread.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        group.interrupt();
        System.out.println("调用了 ThreadGroup.interrupt() 方法");
    }
}
