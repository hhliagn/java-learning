package com.javalearning.demo.design_pattern.factory.abstractFactory1.factory;

import com.javalearning.demo.design_pattern.factory.abstractFactory1.fan.IFan;
import com.javalearning.demo.design_pattern.factory.abstractFactory1.fan.JapanFan;
import com.javalearning.demo.design_pattern.factory.abstractFactory1.tubelight.ITubeLight;
import com.javalearning.demo.design_pattern.factory.abstractFactory1.tubelight.JapanTubeLight;

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
