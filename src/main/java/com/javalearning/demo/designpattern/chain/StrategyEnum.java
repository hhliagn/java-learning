package com.javalearning.demo.designpattern.chain;

import com.javalearning.demo.designpattern.factory.demo2.strategy.LogisticsCalc;
import com.javalearning.demo.designpattern.factory.demo2.strategy.iStrategy;

public enum StrategyEnum{

    PARAM_CHECK(new LogisticsCalc()), GROUPING_CHECK(new LogisticsCalc()),
    UPPER_CONFIRM(new LogisticsCalc()), STATE_SET(new LogisticsCalc()),
    PERSIST(new LogisticsCalc()), CALLBACK(new LogisticsCalc());

    iStrategy strategy;

    StrategyEnum(iStrategy strategy) {
        this.strategy = strategy;
    }
}
