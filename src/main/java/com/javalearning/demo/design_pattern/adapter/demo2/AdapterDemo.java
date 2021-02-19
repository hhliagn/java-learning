package com.javalearning.demo.design_pattern.adapter.demo2;

public class AdapterDemo {

    public static void rechargeLightningPhone(LightningPhone lightningPhone){
        lightningPhone.useLightning();
        lightningPhone.recharge();
    }

    public static void rechargeMicroUsbPhone(MicroUsbPhone microUsbPhone){
        microUsbPhone.useMicroUsb();
        microUsbPhone.recharge();
    }

    public static void main(String[] args) {

        Android android = new Android();
        Iphone iphone = new Iphone();

        rechargeMicroUsbPhone(android);
        rechargeLightningPhone(iphone);

        rechargeMicroUsbPhone(new LightningToMicroUsbAdapter(iphone));
    }
}
