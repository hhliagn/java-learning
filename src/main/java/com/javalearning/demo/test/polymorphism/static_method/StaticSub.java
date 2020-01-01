package com.javalearning.demo.test.polymorphism.static_method;

public class StaticSub extends StaticSuper {
    public static void staticGet(){
        System.out.println("sub static get");
    }
    public void dynamicGet(){
        System.out.println("sub dynamic get");
    }
}
