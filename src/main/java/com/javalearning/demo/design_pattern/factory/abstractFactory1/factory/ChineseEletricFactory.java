package com.javalearning.demo.design_pattern.factory.abstractFactory1.factory;

import com.javalearning.demo.design_pattern.factory.abstractFactory1.fan.ChinaFan;
import com.javalearning.demo.design_pattern.factory.abstractFactory1.fan.IFan;
import com.javalearning.demo.design_pattern.factory.abstractFactory1.tubelight.ChinaTubeLight;
import com.javalearning.demo.design_pattern.factory.abstractFactory1.tubelight.ITubeLight;

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
