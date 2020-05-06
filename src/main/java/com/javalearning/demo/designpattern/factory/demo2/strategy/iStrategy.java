package com.javalearning.demo.designpattern.factory.demo2.strategy;

/**
 * @description cc
 * @date 2020/5/6
 */
public interface iStrategy extends Comparable<iStrategy>{

    int getOrder();
    void apply(Object param);
}
