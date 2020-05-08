package com.javalearning.demo.designpattern.factory.abstractFactory.factory;

import com.javalearning.demo.designpattern.factory.abstractFactory.fan.IFan;
import com.javalearning.demo.designpattern.factory.abstractFactory.fan.JapanFan;
import com.javalearning.demo.designpattern.factory.abstractFactory.tubelight.ITubeLight;
import com.javalearning.demo.designpattern.factory.abstractFactory.tubelight.JapanTubeLight;

/**
 * @description 日本电子工厂
 * @date 2020/5/8
 */
public class JapaneseEletricFactory implements IEletricFactory {

    @Override
    public IFan makeFan() {
        return new JapanFan();
    }

    @Override
    public ITubeLight makeTubeLight() {
        return new JapanTubeLight();
    }
}
