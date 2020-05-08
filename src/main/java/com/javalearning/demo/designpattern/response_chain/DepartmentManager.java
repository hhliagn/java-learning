package com.javalearning.demo.designpattern.response_chain;

import lombok.Setter;

/**
 * @description 部门经理
 * @date 2020/5/8
 */
public class DepartmentManager extends Handler{

    private Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    void handleRequest(int reimburse_amount) {
        if (reimburse_amount > 500){
            successor.handleRequest(reimburse_amount);
        }else {
            System.out.println(this.getClass().getSimpleName() + " handle request");
        }
    }
}
