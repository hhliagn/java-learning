package com.javalearning.demo.design_pattern.bridge.demo1;

public class TV implements Devices {

    private boolean state;

    @Override
    public void on() {
        setState(true);
        System.out.println("Turning On the TV..");
    }

    @Override
    public void off() {
        setState(false);
        System.out.println("Turing Off the TV..");
    }

    @Override
    public boolean isOn() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
