package com.javalearning.demo.design_pattern.bridge;

@FunctionalInterface
public interface Logger {

    void log(String message);

    static Logger info(){
        return message -> System.out.println("info: " + message);
    }

    static Logger warn(){
        return message -> System.out.println("warning: " + message);
    }
}
