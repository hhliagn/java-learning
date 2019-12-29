package com.javalearning.demo.test;

public class SwitchWithoutBreak {

    public static void switchWithoutBreak(int i) {
        switch (i) {
            case 1:
                System.out.println(111);
            case 2:
                System.out.println(222);
            case 3:
                System.out.println(333);
            default:
                System.out.println(0);
        }
    }

    public static void main(String[] args) {
        switchWithoutBreak(1);
    }
}
