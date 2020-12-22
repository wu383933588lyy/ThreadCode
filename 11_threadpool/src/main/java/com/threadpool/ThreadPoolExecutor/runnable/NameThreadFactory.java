package com.threadpool.ThreadPoolExecutor.runnable;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author WuRui
 * @ClassName NameThreadFactory
 * @Date 2020/12/21 14:15
 * @Version 1.0
 * @Description //TODO 实现线程创建工程
 **/
public class NameThreadFactory implements ThreadFactory {

    // 线程 ID
    private final AtomicInteger threadId = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r,"线程-"+ threadId.getAndIncrement());
        System.out.println(thread.getName()+":已经被创建");
        return thread;
    }
}
