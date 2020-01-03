package com.javalearning.demo.test.abstract1;

public class WhitePrinter extends Printer{
    private int field = 10;
    @Override
    void print() {
        System.out.println(field);
    }
}
