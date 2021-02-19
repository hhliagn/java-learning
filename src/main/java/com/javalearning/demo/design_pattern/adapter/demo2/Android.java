package com.javalearning.demo.design_pattern.adapter.demo2;

public class Android implements MicroUsbPhone {

    @Override
    public void recharge() {
        System.out.println("recharge start.");
        System.out.println("recharge end.");
    }

    @Override
    public void useMicroUsb() {
        System.out.println("MicroUsb connected.");
    }
}
