package com.javalearning.demo.commonmistakes.exception.static1;

public class Exceptions {
    public static BusinessException ORDER_EXISTS = new BusinessException(5001, "订单已存在");

    public static BusinessException ORDER_EXISTS(){
        return new BusinessException(5001, "订单已存在");
    }
}
