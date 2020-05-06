package com.javalearning.demo.designpattern.factory.demo2;

import com.javalearning.demo.designpattern.factory.demo2.strategy.StrategyChain;

/**
 * @description
 * @date 2020/5/6
 */
public class CommonOrderCreator implements OrderCreator {
    @Override
    public Response create() {
        //这里再做流程抽象
        StrategyChain strategies = new StrategyChain();
        strategies.excute(new Object());
        return null;
    }

    public static void main(String[] args) {
        StrategyChain strategies = new StrategyChain();
        strategies.excute(new Object());
    }
}
