package com.javalearning.demo.designpattern.factory.demo1;

import com.javalearning.demo.designpattern.factory.demo1.model.Apple;

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
