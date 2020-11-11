package com.thread.group.parent;

/**
 * @Author WuRui
 * @ClassName Dog
 * @Date 2020/11/11 17:05
 * @Version 1.0
 * @Description //TODO
 **/
public class Dog implements Parent{
    @Override
    public void play() {
        System.out.println("Dog is play");
    }

    @Override
    public String eat() {
        return "骨头";
    }
}
