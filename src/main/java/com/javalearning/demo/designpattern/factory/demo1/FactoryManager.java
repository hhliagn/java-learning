package com.javalearning.demo.designpattern.factory.demo1;

/**
 * @description 工厂管理类
 * @date 2020/5/6
 */
public class FactoryManager {

    public iFactory getFactory(String factory){
        switch (factory){
            case "apple":
                return new AppleFactory();
            case "peach":
                return new PeachFactory();
            default:
                return new AppleFactory();
        }
    }
}
