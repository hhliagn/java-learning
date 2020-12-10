package com.javalearning.demo.design_pattern.adapter.demo1;

public class ApplePhone {

    private String model;

    public void recharge(LightingInterface lightingInterface){
        System.out.println(lightingInterface);
        System.out.println("ApplePhone is charging with lightingInterface");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
