package com.javalearning.demo.commonmistakes.exception.handleException.common1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIResponse<T> {
    private boolean success;
    private int code;
    private String message;
    private T data;
}
