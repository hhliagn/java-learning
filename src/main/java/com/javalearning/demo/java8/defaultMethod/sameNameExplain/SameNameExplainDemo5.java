package com.javalearning.demo.java8.defaultMethod.sameNameExplain;

/**
 * @author lhh
 * @date 2021/6/16
 */
public class SameNameExplainDemo5 {

    public static void main(String[] args) {

        new C5().hello();
    }
}


interface A5 {
    default void hello() {
        System.out.println("Hello from A");
    }
}

interface B5 {

    default void hello() {
        System.out.println("Hello from B");
    }
}

/**
 * 不实现无法编译
 */
class C5 implements A5, B5 {

    @Override
    public void hello() {
        B5.super.hello();
    }
}