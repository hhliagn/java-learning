package com.javalearning.demo.test.typeinfo.classInitialization;

public class Initable3 {
    public static int staticNonFinal = 174;
    static {
        System.out.println("Initable3 init");
    }
}
