package com.javalearning.demo.test.PassingThis;

public class Person {
    public void eat(Apple apple){
        Apple peel = apple.getPeel();
        System.out.println("yummy.");
    }
}
