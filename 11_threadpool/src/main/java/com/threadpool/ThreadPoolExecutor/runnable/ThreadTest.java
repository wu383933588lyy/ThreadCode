package com.threadpool.ThreadPoolExecutor.runnable;

import java.util.concurrent.*;

/**
 * @Author WuRui
 * @ClassName ThreadTest
 * @Date 2020/12/21 11:24
 * @Version 1.0
 * @Description //TODO ThreadPoolExecutor 线程池使用，无返回值
 **/
public class ThreadTest {

    public static void main(String[] args) {
        // 线程池的核心线程数
        int corePoolSize = 2;
        // 线程池的最大线程数
        int maxPoolSize = 4;
        // 线程最大空闲时间（配合时间单位使用）
        long keepAliveTime = 10;
        // 时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        // 阻塞队列
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);
        // 线程创建工厂
        ThreadFactory factory = new NameThreadFactory();
        // 线程池拒绝策略
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor executor = null;
        try {
            // 推荐的创建线程池的方式
            // 不推荐使用现成的 API 创建线程
            executor = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,unit,workQueue,factory,handler);
            // 预启动所以核心线程，提升效率
            executor.prestartAllCoreThreads();
            //  test
            for (int i = 0; i < 10; i++) {
                RunnableTask task = new RunnableTask(String.valueOf(i));
                executor.submit(task);
            }
        }finally {
            assert executor != null;
            executor.shutdown();
        }
    }

}
