package com.javalearning.demo.designpattern.factory.abstractFactory1.factory;

import com.javalearning.demo.designpattern.factory.abstractFactory1.fan.IFan;
import com.javalearning.demo.designpattern.factory.abstractFactory1.tubelight.ITubeLight;

/**
 * @description 电子工厂
 * @date 2020/5/8
 */
public interface IEletricFactory {
    IFan makeFan();
    ITubeLight makeTubeLight();
}
