package com.javalearning.demo.test.typeinfo.classInitialization;

import java.util.Random;

public class ClassInitialization {
    public static Random random = new Random();

    public static void main(String[] args) throws ClassNotFoundException {
        Class a = Initable.class;
        System.out.println("after Initable init");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);

//        Class<?> aClass = Class.forName("com.javalearning.demo.Test.typeinfo.classInitialization.Initable2");
//        System.out.println("after Initable2 init");
        System.out.println(Initable2.staticNonFinal);

        Class<?> aClass = Class.forName("com.javalearning.demo.test.typeinfo.classInitialization.Initable3");
        System.out.println("after Initable3 init");
        System.out.println(Initable3.staticNonFinal);
    }
}
