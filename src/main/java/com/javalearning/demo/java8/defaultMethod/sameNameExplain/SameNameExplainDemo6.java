package com.javalearning.demo.java8.defaultMethod.sameNameExplain;

/**
 * @author lhh
 * @date 2021/6/16
 */
public class SameNameExplainDemo6 {

    public static void main(String[] args) {

        System.out.println(new C6().getNumber());
    }
}


interface A6 {
    default Number getNumber() {
        return 100;
    }
}

interface B6 {

    default Integer getNumber() {
        return 42;
    }
}

/**
 * 不实现无法编译
 */
class C6 implements A6, B6 {

    @Override
    public Integer getNumber() {
        return B6.super.getNumber();
    }
}