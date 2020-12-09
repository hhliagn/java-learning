package com.javalearning.demo.design_pattern.response_chain.next_type;

import com.javalearning.demo.design_pattern.response_chain.next_type.model.Handler;

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
