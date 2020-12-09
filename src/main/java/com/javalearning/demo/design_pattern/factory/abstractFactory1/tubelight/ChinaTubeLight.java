package com.javalearning.demo.design_pattern.factory.abstractFactory1.tubelight;

/**
 * @description
 * @date 2020/5/8
 */
public class ChinaTubeLight implements ITubeLight {


    @Override
    public void light() {
        System.out.println("china tubelight light-ing");
    }
}
