package com.javalearning.demo.test.polymorphism.test2;

public class TestPolymorphism {
    public static void main(String[] args) {
        Super sub = new Sub();
        System.out.println(sub.field); //0:编译时解析
        System.out.println(sub.getField());

        Sub sub1 = new Sub();
        System.out.println(sub1.field);
        System.out.println(sub1.getField());
        System.out.println(sub1.getSuperField());
    }
}
