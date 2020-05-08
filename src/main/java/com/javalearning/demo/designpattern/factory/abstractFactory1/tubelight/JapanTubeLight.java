package com.javalearning.demo.designpattern.factory.abstractFactory1.tubelight;

/**
 * @description
 * @date 2020/5/8
 */
public class JapanTubeLight implements ITubeLight {

    @Override
    public void light() {
        System.out.println("japan tubelight light-ing");
    }
}
