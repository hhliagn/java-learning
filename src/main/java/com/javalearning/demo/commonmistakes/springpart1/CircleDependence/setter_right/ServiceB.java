package com.javalearning.demo.commonmistakes.springpart1.CircleDependence.setter_right;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2020/5/16
 */
@Component
public class ServiceB {
    private ServiceA serviceA;

    @Autowired
    public void setServiceA(ServiceA serviceA){
        this.serviceA = serviceA;
        System.out.println("ServiceB set ServiceA");
    }

    public ServiceB(){
        System.out.println("ServiceB constructing");
    }

    public void foo(){
        System.out.println("ServiceB foo");
    }
}
