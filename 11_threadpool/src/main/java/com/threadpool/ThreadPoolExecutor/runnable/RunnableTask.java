package com.threadpool.ThreadPoolExecutor.runnable;

/**
 * @Author WuRui
 * @ClassName RunnableTask
 * @Date 2020/12/21 14:16
 * @Version 1.0
 * @Description //TODO 线程
 **/
public class RunnableTask implements Runnable{

    private String name;

    public RunnableTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.toString() + " is running!");
            //让任务执行慢点
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "RunnableTask [name=" + name + "]";
    }

}
