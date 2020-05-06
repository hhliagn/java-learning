package com.javalearning.demo.designpattern.factory.demo2.strategy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @description
 * @date 2020/5/6
 */
public class StrategyChain extends ArrayList<iStrategy> {

    public StrategyChain(){
        add(new ReviewStrategy());
        add(new LogisticsCalc());
        add(new SetState());
    }

    public void excute(Object param){
        Collections.sort(this);
        this.forEach(strategy -> strategy.apply(param));
    }

}
