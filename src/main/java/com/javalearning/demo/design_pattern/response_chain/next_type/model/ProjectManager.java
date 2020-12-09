package com.javalearning.demo.design_pattern.response_chain.next_type.model;

/**
 * @description 项目经理
 * @date 2020/5/8
 */
public class ProjectManager extends Handler{

    private Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(int reimburse_amount) {
        if (reimburse_amount > 100){
            successor.handleRequest(reimburse_amount);
        }else {
            System.out.println(this.getClass().getSimpleName() + " handle request");
        }
    }
}
