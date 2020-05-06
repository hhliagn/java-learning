package com.javalearning.demo.designpattern.factory.demo1;


/**
 * @description 工厂2
 * @date 2020/5/6
 */
public class PeachFactory implements iFactory {
    @Override
    public Peach make() {
        return new Peach();
    }
}
