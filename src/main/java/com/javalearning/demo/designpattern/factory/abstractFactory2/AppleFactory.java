package com.javalearning.demo.designpattern.factory.abstractFactory2;

import com.javalearning.demo.designpattern.factory.abstractFactory2.model.Apple;

/**
 * @description 工厂1
 * @date 2020/5/6
 */
public class AppleFactory implements iFactory {
    @Override
    public Apple make() {
        return new Apple();
    }
}
