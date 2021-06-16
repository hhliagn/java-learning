package com.javalearning.demo.java8.defaultMethod.sameNameExplain;

/**
 * @author lhh
 * @date 2021/6/16
 */
public class SameNameExplainDemo3 {

    public static void main(String[] args) {

        new C3().hello();
    }
}


interface A3 {
    default void hello() {
        System.out.println("Hello from A");
    }
}

interface B3 extends A3 {

    @Override
    default void hello() {
        System.out.println("Hello from B");
    }
}

class D3 implements A3 {

    @Override
    public void hello() {
        System.out.println("Hello from D");
    }

}

class C3 extends D3 implements A3, B3 {

}