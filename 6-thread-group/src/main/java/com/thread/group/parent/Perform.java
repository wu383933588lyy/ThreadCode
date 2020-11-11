package com.thread.group.parent;

/**
 * @Author WuRui
 * @ClassName Perform
 * @Date 2020/11/11 17:02
 * @Version 1.0
 * @Description //TODO
 **/
public class Perform implements Parent{

    private Parent target;

    public Perform(Parent target) {
        this.target = target;
    }

    public Perform() {
    }

    @Override
    public void play() {
        if (target != null){
            target.play();
        }
    }

    @Override
    public String eat() {
        if (target != null){
            return target.eat();
        }
        return null;
    }
}
