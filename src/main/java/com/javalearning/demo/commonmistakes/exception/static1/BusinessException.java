package com.javalearning.demo.commonmistakes.exception.static1;

public class BusinessException extends Exception{

    private int code;
    private String message;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
