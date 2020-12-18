package com.thread.volatiles.demo;

/**
 * @Author WuRui
 * @ClassName CacheConsistency
 * @Date 2020/11/12 14:38
 * @Version 1.0
 * @Description //TODO
 **/
public class CacheConsistency {

    Boolean flag = Boolean.FALSE;

    int a = 0;

    public void initialize() {
        a = 1;
        flag = Boolean.TRUE;
    }

    public void add() {
        if (flag ) {
                System.out.println(a);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            CacheConsistency cache = new CacheConsistency();
            new Thread(cache::add).start();
            new Thread(cache::initialize).start();
        }
    }
}
