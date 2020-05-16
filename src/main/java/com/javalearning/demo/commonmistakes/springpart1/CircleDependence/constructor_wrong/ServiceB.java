package com.javalearning.demo.commonmistakes.springpart1.CircleDependence.constructor_wrong;

import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2020/5/16
 */
@Component
public class ServiceB {
    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA){
        this.serviceA = serviceA;
        System.out.println("ServiceB constructing");
    }

    public void foo(){
        System.out.println("ServiceB foo");
    }
}
