package com.javalearning.demo.test;

public class LazyInitialize {
    private static String v1;

    public static void main(String[] args) {
        //do something;
        v1 = "lazy initialize";
        System.out.println(v1.length());
    }
}
