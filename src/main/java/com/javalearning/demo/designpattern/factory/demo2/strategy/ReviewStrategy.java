package com.javalearning.demo.designpattern.factory.demo2.strategy;

/**
 * @description
 * @date 2020/5/6
 */
public class ReviewStrategy implements iStrategy,Comparable<iStrategy> {
    @Override
    public int getOrder() {
        return 3;
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
