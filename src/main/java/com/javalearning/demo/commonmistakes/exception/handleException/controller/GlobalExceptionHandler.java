package com.javalearning.demo.commonmistakes.exception.handleException.controller;

import com.javalearning.demo.commonmistakes.exception.handleException.common1.APIException;
import com.javalearning.demo.commonmistakes.exception.handleException.common1.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @SuppressWarnings(value = "unchecked")
    @ExceptionHandler
    public APIResponse handle(HttpServletRequest request, HandlerMethod handlerMethod, APIException exception){
        log.warn("访问 uri = {} -> method = {} : 发生异常", request.getRequestURI(), handlerMethod.toString(), exception);
        return new APIResponse(false, exception.getError().getCode(), exception.getMessage(), null);
    }
}
