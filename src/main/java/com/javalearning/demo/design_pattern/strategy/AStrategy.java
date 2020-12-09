package com.javalearning.demo.design_pattern.strategy;

/**
 * @description 策略A
 * @date 2020/5/9
 */
public class AStrategy implements iStrategy{
    @Override
    public Integer add(Integer num1, Integer num2) {
        System.out.println("AStrategy add");
        return 1;
    }

    @Override
    public Integer substract(Integer num1, Integer num2) {
        System.out.println("AStrategy substract");
        return 1;
    }
}
