package com.javalearning.demo.test.inner_class.test1;

public class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.getInner();
    }
}
