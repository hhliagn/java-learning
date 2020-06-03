package com.javalearning.demo.commonmistakes.redundantcode.reflection.demo;

import com.javalearning.demo.commonmistakes.redundantcode.reflection.right.BankAPIField;
import lombok.Data;

@Data
@BankAPI(url = "/bank/createUser", desc = "订单创建接口")
public class CreateUserAPI extends AbstractAPI {

    @BankAPIField(order = 1, length = 10, type = "S")
    private String name;

    @BankAPIField(order = 2, length = 18, type = "S")
    private String identity;

    @BankAPIField(order = 3, length = 10, type = "S")
    private String mobile;

    @BankAPIField(order = 4, length = 5, type = "N")
    private int age;
}
