package com.javalearning.demo.design_pattern.bridge;

public class BridgeDemo {

    // 抽象和实现分离，不绑定，可以自由替换
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
