package com.javalearning.demo.design_pattern.adapter.demo1;

public class AndroidPhone {

    private String model;

    public void recharge(MicroUsbInterface microUsbInterface){
        System.out.println(microUsbInterface);
        System.out.println("AndroidPhone is charging with microUserInterface");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
