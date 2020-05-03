package com.javalearning.demo.commonmistakes.exception.handleException.common1;

public enum Error500 implements Error{
    SYSTEM_ERROR(50001, "系统错误");

    int code;
    String message;

    Error500(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
