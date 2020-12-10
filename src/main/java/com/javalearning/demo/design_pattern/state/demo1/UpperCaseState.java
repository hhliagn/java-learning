package com.javalearning.demo.design_pattern.state.demo1;

public class UpperCaseState implements State{

    @Override
    public void write(String message) {
        System.out.println(message.toUpperCase());
    }
}
