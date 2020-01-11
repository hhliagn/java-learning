package com.javalearning.demo.test.generics.coffee;

public class Coffee {
    private static long counter = 0;
    private final long id = counter ++; //不能用static，否则id只会在第一次初始化了,拿到的就永远是0

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
