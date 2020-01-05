package com.javalearning.demo.test.inner_class.mutil_interfaces;

public class Test {
    static void taskA(A a){

    }
    static void taskB(B b){

    }
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        taskA(x);
        taskA(y);
        taskB(x);
        taskB(y.makeB());
    }
}
