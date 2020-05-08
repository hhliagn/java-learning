package com.javalearning.demo.designpattern.factory.abstractFactory.factory;

import com.javalearning.demo.designpattern.factory.abstractFactory.fan.ChinaFan;
import com.javalearning.demo.designpattern.factory.abstractFactory.fan.IFan;
import com.javalearning.demo.designpattern.factory.abstractFactory.tubelight.ChinaTubeLight;
import com.javalearning.demo.designpattern.factory.abstractFactory.tubelight.ITubeLight;

/**
 * @description 中国电子工厂
 * @date 2020/5/8
 */
public class ChineseEletricFactory implements IEletricFactory {

    @Override
    public IFan makeFan() {
        return new ChinaFan();
    }

    @Override
    public ITubeLight makeTubeLight() {
        return new ChinaTubeLight();
    }
}
