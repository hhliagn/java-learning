package com.javalearning.demo.test.initialize;

public class TestStaticInitialize {
    static String v1 = "ABCD";
    static String v2;
    static {
        v2 = "EFG";
    }

    static void printv(){
        System.out.println(v1);
        System.out.println(v2);
    }

    public static void main(String[] args) {
        TestStaticInitialize.printv();
    }
}
