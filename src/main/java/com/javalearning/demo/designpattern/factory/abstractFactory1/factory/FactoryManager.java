package com.javalearning.demo.designpattern.factory.abstractFactory1.factory;

/**
 * @description
 * @date 2020/5/8
 */
public class FactoryManager {

    public static IEletricFactory getFactory(String factory){
        switch (factory){
            case "china":
                return new ChineseEletricFactory();
            case "japan":
                return new JapaneseEletricFactory();
            default:
                return new ChineseEletricFactory();
        }
    }
}
