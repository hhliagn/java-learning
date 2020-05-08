package com.javalearning.demo.designpattern.factory.abstractFactory1;

import com.javalearning.demo.designpattern.factory.abstractFactory1.factory.FactoryManager;
import com.javalearning.demo.designpattern.factory.abstractFactory1.factory.IEletricFactory;
import com.javalearning.demo.designpattern.factory.abstractFactory1.fan.IFan;
import com.javalearning.demo.designpattern.factory.abstractFactory1.tubelight.ITubeLight;

/**
 * @description
 * @date 2020/5/8
 */
public class Main {

    public static void main(String[] args) {
        IEletricFactory eletricFactory = FactoryManager.getFactory("china");
        IFan iFan = eletricFactory.makeFan();
        ITubeLight iTubeLight = eletricFactory.makeTubeLight();
        iFan.spin();
        iTubeLight.light();
    }
}
