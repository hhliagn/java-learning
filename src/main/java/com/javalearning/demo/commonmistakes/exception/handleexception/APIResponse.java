package com.javalearning.demo.commonmistakes.exception.handleexception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description
 * @date 2020/4/27
 */
@AllArgsConstructor
@Data
public class APIResponse<T> {

    private boolean success;
    private T data;
    private Integer code;
    private String message;


}
