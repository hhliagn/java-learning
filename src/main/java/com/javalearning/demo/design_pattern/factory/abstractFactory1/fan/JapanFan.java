package com.javalearning.demo.design_pattern.factory.abstractFactory1.fan;

/**
 * @description
 * @date 2020/5/8
 */
public class JapanFan implements IFan {

    @Override
    public void spin() {
        System.out.println("japan fan spin-ing");
    }
}
