package com.javalearning.demo.test.generics;

import org.omg.CORBA.Object;

public class Erased<T> {
    private static final int SIZE = 100;
    public static <T> void f(Object arg){
//        if (arg instanceof T) {}
//        new T();
//        T[] ts = new T[SIZE];
        T[] ts1 = (T[]) new Object[SIZE];
    }

}
