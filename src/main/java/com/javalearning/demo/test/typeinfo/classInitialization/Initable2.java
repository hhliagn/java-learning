package com.javalearning.demo.test.typeinfo.classInitialization;

public class Initable2 {
    public static int staticNonFinal = 57;
    static {
        System.out.println("Initable2 init");
    }
}
