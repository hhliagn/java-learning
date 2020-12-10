package com.javalearning.demo.design_pattern.adapter.demo1;

/**
 * 适配器可以由A接口转成B接口，也可以从B接口转成A接口，所以对于使用A、B接口的程序来说，它是通用的
 */
public class Main {

    public static void main(String[] args) {
        Adapter adapter = new Adapter();

        ApplePhone applePhone = new ApplePhone();
        applePhone.recharge(adapter);

        AndroidPhone androidPhone = new AndroidPhone();
        androidPhone.recharge(adapter);
    }
}
