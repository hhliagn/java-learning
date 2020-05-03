package com.javalearning.demo.test.polymorphism.static_method;

public class TestStaticMethod {
    public static void main(String[] args) {
        StaticSuper staticSub = new StaticSub();
        staticSub.staticGet(); //base static1 get
        staticSub.dynamicGet();
    }
}
