package com.thread.sync.part2;

import java.util.Vector;

/**
 * @Author WuRui
 * @ClassName LockEliminationDemo
 * @Date 2020/11/20 16:09
 * @Version 1.0
 * @Description //TODO 锁消除 Demo
 **/
public class LockEliminationDemo {

    public static void vectorTest(){
        Vector<String> vector = new Vector<String>();
        for (int i = 0; i < 10; i++) {
            vector.add(String.valueOf(i));
        }
        System.out.println(vector);
    }

    public static void main(String[] args) {
        vectorTest();
    }
}
