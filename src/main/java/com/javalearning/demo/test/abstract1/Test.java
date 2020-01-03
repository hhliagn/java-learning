package com.javalearning.demo.test.abstract1;

public class Test {
    public static void main(String[] args) {
        Printer printer = new WhitePrinter();
        printer.print();
        //printer before print
        //0
        //printer after print
        //10
    }
}
