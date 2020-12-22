package com.threadpool.ThreadPoolExecutor.runnable;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author WuRui
 * @ClassName MyIgnorePolicy
 * @Date 2020/12/21 14:15
 * @Version 1.0
 * @Description //TODO 线程池拒接策略
 **/
public class MyIgnorePolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        // 可做日志记录等
        System.err.println(runnable.toString() + " rejected");
    }
}
