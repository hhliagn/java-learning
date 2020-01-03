package com.javalearning.demo.test.abstract1;

public abstract class Printer {
    abstract void print();
    public Printer(){
        System.out.println("printer before print");
        print();
        System.out.println("printer after print");
    }
}
