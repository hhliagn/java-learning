package com.javalearning.demo.test.util;

public class Tuple {
    public static <A ,B> TwoTuple<A, B> tuple(A a, B b){
        return new TwoTuple<A, B>(a, b);
    }
}
