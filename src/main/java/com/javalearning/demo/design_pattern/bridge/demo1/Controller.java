package com.javalearning.demo.design_pattern.bridge.demo1;

public class Controller {

    private Devices devices;

    public Controller(Devices devices) {
        this.devices = devices;
    }

    public void power(){
        if (devices.isOn()){
            devices.off();
        }else {
            devices.on();
        }
    }
}
