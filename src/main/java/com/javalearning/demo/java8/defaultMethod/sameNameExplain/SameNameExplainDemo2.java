package com.javalearning.demo.java8.defaultMethod.sameNameExplain;

/**
 * @author lhh
 * @date 2021/6/16
 */
public class SameNameExplainDemo2 {

    public static void main(String[] args) {

        new C2().hello();
    }
}


interface A2 {
    default void hello() {
        System.out.println("Hello from A");
    }
}

interface B2 extends A2 {

    @Override
    default void hello() {
        System.out.println("Hello from B");
    }
}

class D2 implements A2 {

}

class C2 extends D2 implements A2, B2 {

}