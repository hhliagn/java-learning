package com.javalearning.demo.test.inner_class.callback;

public class Callee1 implements Incrementable {
    private int i = 0;
    @Override
    public void increment() {
        i ++;
        System.out.println(i);
    }
}
