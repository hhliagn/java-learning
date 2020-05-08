package com.javalearning.demo.designpattern.response_chain;

import lombok.Setter;

/**
 * @description 责任链抽象类
 * @date 2020/5/8
 */
public abstract class Handler {
    abstract void handleRequest(int reimburse_amount);
}
