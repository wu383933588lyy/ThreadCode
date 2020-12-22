package com.threadpool.ThreadPoolExecutor.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @Author WuRui
 * @ClassName FactorialCalculator
 * @Date 2020/12/21 14:36
 * @Version 1.0
 * @Description //TODO ThreadPoolExecutor 线程池使用，有返回值
 **/
public class FactorialCalculator implements Callable<String> {

    private Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    /**
     * 返回阶乘
     * @return
     * @throws Exception
     */
    @Override
    public String call() throws Exception {
        int result =1;
        if (number ==0 || number == 1){
            result = 1;
        }else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MICROSECONDS.sleep(200);
            }
        }
        return String.format("%s输出%d的阶乘为：%d\n", Thread.currentThread().getName(), number, result);
    }
}
