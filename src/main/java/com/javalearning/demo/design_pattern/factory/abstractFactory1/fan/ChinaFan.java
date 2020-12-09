package com.javalearning.demo.design_pattern.factory.abstractFactory1.fan;

/**
 * @description IChineseFan
 * @date 2020/5/8
 */
public class ChinaFan implements IFan{

    @Override
    public void spin() {
        System.out.println("china fan spin-ing");
    }
}
