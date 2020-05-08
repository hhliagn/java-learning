package com.javalearning.demo.designpattern.response_chain;

/**
 * @description test main
 * @date 2020/5/8
 */
public class Main {
    public static void main(String[] args) {
        Handler handlerChain = ResponseChainInitializer.getInstance();
        handlerChain.handleRequest(1000);
    }
}
