package com.javalearning.demo.design_pattern.adapter;

public class LightningToMicroUsbAdapter implements MicroUsbPhone {

    private LightningPhone lightningPhone;

    public LightningToMicroUsbAdapter(LightningPhone lightningPhone) {
        this.lightningPhone = lightningPhone;
    }

    @Override
    public void recharge() {
        lightningPhone.recharge();
    }

    @Override
    public void useMicroUsb() {
        lightningPhone.useLightning();
    }
}
