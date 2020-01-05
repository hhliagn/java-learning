package com.javalearning.demo.test.inner_class.mutil_interfaces;

public class Y implements A {
    B makeB(){
        return new B() {
        };
    }
}
