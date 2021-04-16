package com.javalearning.demo.sort_test;

import lombok.Data;

/**
 * @author lhh
 * @date 2021/4/8
 */
@Data
public class OrderPayRecord {

    private String payment;

    public OrderPayRecord(String payment) {
        this.payment = payment;
    }
}
