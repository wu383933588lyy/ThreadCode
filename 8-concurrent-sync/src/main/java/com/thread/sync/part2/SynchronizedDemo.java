package com.thread.sync.part2;

/**
 * @Author WuRui
 * @ClassName SynchronizedDemo
 * @Date 2020/11/18 9:21
 * @Version 1.0
 * @Description //TODO
 **/
public class SynchronizedDemo {

    public void test(){
        synchronized (this){
            System.out.println("Method start.....");
        }
    }
}
