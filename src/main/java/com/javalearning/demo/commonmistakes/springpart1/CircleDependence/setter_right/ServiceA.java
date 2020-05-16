package com.javalearning.demo.commonmistakes.springpart1.CircleDependence.setter_right;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2020/5/16
 */
@Component
public class ServiceA {

    private ServiceB serviceB;

    @Autowired
    public void setServiceB(ServiceB serviceB){
        this.serviceB = serviceB;
        System.out.println("ServiceA set ServiceB");
    }

    public ServiceA(){
        System.out.println("ServiceA constructing");
    }

    public void foo(){
        System.out.println("ServiceA foo");
        serviceB.foo();
    }
}
