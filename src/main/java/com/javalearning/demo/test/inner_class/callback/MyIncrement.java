package com.javalearning.demo.test.inner_class.callback;

public class MyIncrement {
    public void increment(){
        System.out.println("other operation");
    }
    public static void f(MyIncrement myIncrement){
        myIncrement.increment();
    }
}
