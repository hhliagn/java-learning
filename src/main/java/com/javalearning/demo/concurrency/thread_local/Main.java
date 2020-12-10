package com.javalearning.demo.concurrency.thread_local;

public class Main {

    public static void main(String[] args) {
        new Thread(new Task1()).start();
        new Thread(new Task2()).start();
    }
}
