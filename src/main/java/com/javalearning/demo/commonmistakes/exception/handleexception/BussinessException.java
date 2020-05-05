package com.javalearning.demo.commonmistakes.exception.handleexception;

import lombok.Data;

/**
 * @description bussiness exception
 * @date 2020/4/27
 */
@Data
public class BussinessException extends Exception{

    private String message;
    private Integer code;

    public BussinessException(String message,Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }
}
