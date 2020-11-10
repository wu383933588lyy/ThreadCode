package com.thread.interruption.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author WuRui
 * @ClassName TaskQueue
 * @Date 2020/11/10 16:06
 * @Version 1.0
 * @Description //TODO 自定义一个任务队列，封装了 LinkedBlockingQueue
 **/
public class TaskQueue<T> {

    private static final int MAX_TASKS = 1000;

    private BlockingQueue<T> queue = new LinkedBlockingDeque<>(MAX_TASKS);

    /**
     * putTask() 可以对线程中断做出响应
     * @param t
     * @throws InterruptedException
     */
    public void putTask(T t)throws InterruptedException{
        queue.put(t);
    }

    /**
     * getTask() 可以对中断做出响应
     * @return
     * @throws InterruptedException
     */
    public T getTask() throws InterruptedException{
        return queue.take();
    }
}
