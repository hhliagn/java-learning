package com.javalearning.demo.designpattern.factory.abstractFactory.fan;

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
