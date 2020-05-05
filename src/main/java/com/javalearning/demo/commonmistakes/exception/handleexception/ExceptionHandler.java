package com.javalearning.demo.commonmistakes.exception.handleexception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @description exception handler
 * @date 2020/4/27
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    private static int SYSTEM_ERROR_CODE = 500;
    private static String SYSTEM_ERROR_MSG = "系统繁忙，请稍后再试";

    @org.springframework.web.bind.annotation.ExceptionHandler
    public APIResponse handleException(HttpServletRequest request, HandlerMethod method, Exception ex){
        if (ex instanceof BussinessException){
            BussinessException exception = (BussinessException) ex;
            log.warn(String.format("访问 %s -> %s 出现业务异常", request.getRequestURI(), method.toString()), exception);
            return new APIResponse(false, null, exception.getCode(), exception.getMessage());
        }else {
            log.warn(String.format("访问 %s -> %s 出现系统异常", request.getRequestURI(), method.toString()), ex);
            return new APIResponse(false, null, SYSTEM_ERROR_CODE, SYSTEM_ERROR_MSG);
        }
    }

}
