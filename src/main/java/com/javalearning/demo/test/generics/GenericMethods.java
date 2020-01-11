package com.javalearning.demo.test.generics;

public class GenericMethods {
    public <T> void f(T t){
        System.out.println(t.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f("");
        genericMethods.f(1);
        genericMethods.f(1.0);
        genericMethods.f(1.0f);
        genericMethods.f('c');
//        genericMethods.f(null);
    }
}
