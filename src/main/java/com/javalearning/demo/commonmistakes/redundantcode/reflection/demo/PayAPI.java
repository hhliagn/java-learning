package com.javalearning.demo.commonmistakes.redundantcode.reflection.demo;

import com.javalearning.demo.commonmistakes.redundantcode.reflection.right.BankAPIField;
import lombok.Data;

import java.math.BigDecimal;

@Data
@BankAPI(url =  "/bank/pay", desc = "订单支付接口")
public class PayAPI extends AbstractAPI {

    @BankAPIField(order = 1, length = 20, type =  "N")
    private long userId;

    @BankAPIField(order = 2, length = 10, type =  "M")
    private BigDecimal amount;
}
