package com.javalearning.demo.design_pattern.bridge.demo2;

public class BridgeDemo {

    public static void main(String[] args) {

        SimpleAccount simpleAccount = new SimpleAccount(100);

        simpleAccount.withdraw(75);

        if (simpleAccount.isBalanceLow()){
            simpleAccount.setLogger(Logger.warn());
        }

        simpleAccount.withdraw(10);
        simpleAccount.withdraw(100);
    }
}
