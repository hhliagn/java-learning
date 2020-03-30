package com.javalearning.demo.test.generics.SelfBounding;

public class SelfBoundingMethods {
    public static <T extends SelfBounded<T>> T f(T args){
        return args.get();
    }

    public static void main(String[] args) {
        f(new A());
//        f(new B()); //error
    }
}
