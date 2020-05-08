package com.javalearning.demo.designpattern.factory.abstractFactory2;


import com.javalearning.demo.designpattern.factory.abstractFactory2.model.Peach;

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
