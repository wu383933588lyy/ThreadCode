package com.threadpool.folkjoin.recursivetask;

import java.util.concurrent.RecursiveTask;

/**
 * @Author WuRui
 * @ClassName SumTask
 * @Date 2020/12/21 16:14
 * @Version 1.0
 * @Description //TODO ForkJoin 线程池 （有返回值）
 **/
public class SumTask extends RecursiveTask<Integer> {
    /**
     * 每个小任务，最多只累加20个数
     */
    private static final int THRESHOLD = 20;
    private int nums[];
    private int start;
    private int end;

    public SumTask(int[] nums, int start, int end) {
        super();
        this.nums = nums;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (end -start < THRESHOLD){
            for (int i = start; i < end; i++) {
                sum += nums[i];
            }
            return sum;
        }else {
            //当分块超过阈值时，则需要对数据进行拆分
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(nums, start, mid);
            SumTask rightTask = new SumTask(nums, mid, end);
            //并行执行两个小任务
            leftTask.fork();
            rightTask.fork();
            //把两个小任务累加合并
            return leftTask.join() + rightTask.join();
        }
    }
}
