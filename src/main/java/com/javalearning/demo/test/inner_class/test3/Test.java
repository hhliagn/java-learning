package com.javalearning.demo.test.inner_class.test3;

public class Test {
    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        DotThis.Inner inner = dotThis.inner();
        inner.outer().f();
    }
}
