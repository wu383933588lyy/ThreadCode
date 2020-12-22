package com.threadpool.folkjoin.recursivetask;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @Author WuRui
 * @ClassName ForkJoinPoolTask
 * @Date 2020/12/21 16:18
 * @Version 1.0
 * @Description //TODO ForkJoin 线程池使用（有返回值）
 **/
public class ForkJoinPoolTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 需求：对于长度为 10000 的元素数组进行累加
        int[] nums=new int[10000];
        Random random = new Random();
        int total = 0;
        // 初始化数组元素
        long start = System.nanoTime();
        for (int i = 0; i < nums.length; i++) {
            int temp = random.nextInt(100);
            nums[i] = temp;
            total +=nums[i];
        }
        long end = System.nanoTime();
        System.out.println("初始化数组用时：" + (end - start) + "纳秒, 初始化数组总和:" + total);

        long startTask = System.nanoTime();
        // 创建线程
        SumTask task = new SumTask(nums, 0, nums.length);
        // 创建线程池
        ForkJoinPool pool = new ForkJoinPool();
        // 提交任务，存在返回值
        ForkJoinTask<Integer> future = pool.submit(task);
        // 显示结果
        long endTask = System.nanoTime();
        System.out.println("线程池计算用时：" + (endTask - startTask) + "纳秒, 线程池执行结果:" + future.get());
        //关闭多线程
        pool.shutdown();
    }
}
