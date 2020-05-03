package com.javalearning.demo.commonmistakes.exception.handleException.controller;

import com.javalearning.demo.commonmistakes.exception.handleException.common1.APIException;
import com.javalearning.demo.commonmistakes.exception.handleException.common1.APIResponse;
import com.javalearning.demo.commonmistakes.exception.handleException.common1.Error403;
import com.javalearning.demo.commonmistakes.exception.handleException.common1.Error500;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ExceptionController {

    @GetMapping("/exception")
    public APIResponse exception(@RequestParam boolean isSystemError) throws APIException {
        if (isSystemError){
            throw new APIException(Error500.SYSTEM_ERROR);
        }else {
            throw new APIException(Error403.REQUEST_PARAM_ERROR);
        }
    }
}
