package com.javalearning.demo.design_pattern.adapter;

public class Iphone implements LightningPhone {

    @Override
    public void recharge() {
        System.out.println("recharge start.");
        System.out.println("recharge end.");
    }

    @Override
    public void useLightning() {
        System.out.println("Lightning connected.");
    }
}
