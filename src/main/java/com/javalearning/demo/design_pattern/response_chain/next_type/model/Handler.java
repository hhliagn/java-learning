package com.javalearning.demo.design_pattern.response_chain.next_type.model;

/**
 * @description 责任链抽象类
 * @date 2020/5/8
 */
public abstract class Handler {
    public abstract void handleRequest(int reimburse_amount);
}
