package com.javalearning.demo.test.typeinfo.test;

public class Test {
    public static void main(String[] args) {
        char[] a = new char[]{'a','b','c'};
        test(a);
    }
    static void test(Object object){
        Class<?> aClass = object.getClass();
        System.out.println(aClass);
    }
}
