package com.javalearning.demo.commonmistakes.exception.handleException.common1;

public enum  Error403 implements Error {
    REQUEST_PARAM_ERROR(40301, "参数错误");

    int code;
    String message;

    Error403(int code, String message) {
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
