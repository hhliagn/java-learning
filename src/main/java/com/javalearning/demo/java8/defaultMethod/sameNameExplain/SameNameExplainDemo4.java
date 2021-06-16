package com.javalearning.demo.java8.defaultMethod.sameNameExplain;

/**
 * @author lhh
 * @date 2021/6/16
 */
public class SameNameExplainDemo4 {

    public static void main(String[] args) {

        new C4().hello();
    }
}


interface A4 {
    default void hello() {
        System.out.println("Hello from A");
    }
}

interface B4 extends A4 {

    @Override
    default void hello() {
        System.out.println("Hello from B");
    }
}

abstract class D4 implements A4 {

    @Override
    public abstract void hello();

}

class C4 extends D4 implements A4, B4 {

    @Override
    public void hello() {
        System.out.println("Hello from C");
    }
}