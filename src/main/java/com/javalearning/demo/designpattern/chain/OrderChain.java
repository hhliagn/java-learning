package com.javalearning.demo.designpattern.chain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description
 * @date 2020/5/6
 */
public class OrderChain extends ArrayList<StrategyEnum> {

    public void excute(){
        Collections.sort(this);
        this.forEach(strategy -> StrategyEnum.valueOf(strategy.name()).strategy.apply(new Object()));
    }

    public OrderChain() {
        add(StrategyEnum.PARAM_CHECK);
        add(StrategyEnum.STATE_SET);
        add(StrategyEnum.PERSIST);
        add(StrategyEnum.CALLBACK);
    }
}
