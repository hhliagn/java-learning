package com.javalearning.demo.designpattern.response_chain.list_type_ordered.strategy;

/**
 * @description
 * @date 2020/5/6
 */
public class LogisticsCalc implements iStrategy {

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public void apply(Object param) {
        System.out.println(this.getClass().getSimpleName());
    }

    @Override
    public int compareTo(iStrategy o) {
        return this.getOrder() - o.getOrder();
    }
}
