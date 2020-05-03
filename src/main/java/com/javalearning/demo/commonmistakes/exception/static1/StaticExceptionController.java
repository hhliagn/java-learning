package com.javalearning.demo.commonmistakes.exception.static1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StaticExceptionController {

    @GetMapping("/wrong")
    public void wrong(){
        try {
            crateOrderWrong();
        } catch (BusinessException e) {
            log.error("create", e);
        }
        try {
            cancelOrderWrong();
        } catch (BusinessException e) {
            log.error("cancel", e);
        }
    }

    @GetMapping("/right")
    public void right(){
        try {
            crateOrderRight();
        } catch (BusinessException e) {
            log.error("create", e);
        }
        try {
            cancelOrderRight();
        } catch (BusinessException e) {
            log.error("cancel", e);
        }
    }

    private void cancelOrderWrong() throws BusinessException {
        throw Exceptions.ORDER_EXISTS;
    }

    private void crateOrderWrong() throws BusinessException {
        throw Exceptions.ORDER_EXISTS;
    }

    private void cancelOrderRight() throws BusinessException {
        throw Exceptions.ORDER_EXISTS();
    }

    private void crateOrderRight() throws BusinessException {
        throw Exceptions.ORDER_EXISTS();
    }



}
