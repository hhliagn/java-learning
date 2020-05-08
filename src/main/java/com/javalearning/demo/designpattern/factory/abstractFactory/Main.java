package com.javalearning.demo.designpattern.factory.abstractFactory;

import com.javalearning.demo.designpattern.factory.abstractFactory.factory.FactoryManager;
import com.javalearning.demo.designpattern.factory.abstractFactory.factory.IEletricFactory;
import com.javalearning.demo.designpattern.factory.abstractFactory.fan.IFan;
import com.javalearning.demo.designpattern.factory.abstractFactory.tubelight.ITubeLight;

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
