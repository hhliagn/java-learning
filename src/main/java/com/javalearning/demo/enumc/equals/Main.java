package com.javalearning.demo.enumc.equals;

import com.javalearning.demo.enumc.concrete_method.Direction1;

public class Main {

    public static void main(String[] args) {
        // enum 是单例的，所以可以用 == 判等
        System.out.println(Direction1.EAST == Direction1.EAST);
    }
}
