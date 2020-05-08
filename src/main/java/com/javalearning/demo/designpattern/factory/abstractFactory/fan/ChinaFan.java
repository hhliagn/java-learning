package com.javalearning.demo.designpattern.factory.abstractFactory.fan;

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
