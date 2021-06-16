package com.javalearning.demo.java8.defaultMethod.sameNameExplain;

/**
 * @author lhh
 * @date 2021/6/16
 */
public class SameNameExplainDemo1 {

    public static void main(String[] args) {

        new C().hello();
    }
}


interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}

interface B extends A {

    @Override
    default void hello() {
        System.out.println("Hello from B");
    }
}

class C implements B {

}
