package com.javalearning.demo.dynamic_proxy;

public class User implements People{


    @Override
    public void eat(String food) {
        System.out.println("user eat " + food);
    }
}
