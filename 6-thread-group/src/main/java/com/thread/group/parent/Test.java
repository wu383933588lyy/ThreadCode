package com.thread.group.parent;

/**
 * @Author WuRui
 * @ClassName Test
 * @Date 2020/11/11 17:09
 * @Version 1.0
 * @Description //TODO
 **/
public class Test {

    public static void main(String[] args) {
        Perform person = new Person();
        person.play();
        Dog dog = new Dog();
        Perform perform = new Perform(dog);
        dog.play();
        perform.play();
        perform.eat();
    }
}
