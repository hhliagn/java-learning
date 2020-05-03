package com.javalearning.demo.commonmistakes.exception.handleException.common1;

import lombok.Data;

@Data
public class APIException extends Exception {

    private Error error;
    private String message;

    public APIException(Error error) {
        super(error.getMessage());
        this.error = error;
        this.message = error.getMessage();
    }
}

