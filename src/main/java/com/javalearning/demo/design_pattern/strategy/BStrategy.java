package com.javalearning.demo.design_pattern.strategy;

/**
 * @description 策略B
 * @date 2020/5/9
 */
public class BStrategy implements iStrategy {


    @Override
    public Integer add(Integer num1, Integer num2) {
        System.out.println("BStrategy add");
        return 1;
    }

    @Override
    public Integer substract(Integer num1, Integer num2) {
        System.out.println("BStrategy substract");
        return 1;
    }
}
