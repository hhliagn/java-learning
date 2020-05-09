package com.javalearning.demo.designpattern.response_chain.next_type.model;

/**
 * @description 总经理
 * @date 2020/5/8
 */
public class GeneralManager extends Handler {

    private Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(int reimburse_amount) {
        assert reimburse_amount > 500;
        System.out.println(this.getClass().getSimpleName() + " handle request");
    }
}
