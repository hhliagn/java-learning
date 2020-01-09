package com.javalearning.demo.test.typeinfo.SimpleProxyDemo;

public class RealObject implements Interface1{

    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("something else " + args);
    }
}
