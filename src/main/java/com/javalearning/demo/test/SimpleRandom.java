package com.javalearning.demo.test;

public class SimpleRandom {

    public static boolean condition(){
        double random = Math.random();
        boolean result = random < 0.99;
        System.out.println(random);
        return result;
    }

    public static void main(String[] args) {
        while (condition()) System.out.println("inside while");
        System.out.println("Exit while");
    }
}
