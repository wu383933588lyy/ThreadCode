package com.threadpool.ThreadPoolExecutor.callable;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author WuRui
 * @ClassName CallableTest
 * @Date 2020/12/21 14:47
 * @Version 1.0
 * @Description //TODO ThreadPoolExecutor 线程池使用，有返回值
 **/
public class CallableTest {

    public static void main(String[] args) {
        ExecutorService executor = null;
        int count = 10;
        try {
            // !!! 不推荐使用Executors的静态方法创建线程池 !!!
            executor = Executors.newCachedThreadPool();
            ExecutorCompletionService<String> service = new ExecutorCompletionService<>(executor);
            for (int i = 0; i < 10; i++) {
                FactorialCalculator calculator = new FactorialCalculator(i);
                service.submit(calculator);
            }
            for (int i = 0; i < 10; i++) {
                Future<String> result = service.take();
                System.out.println(result.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert executor != null;
            executor.shutdown();
        }
    }
}
