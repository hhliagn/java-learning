package com.javalearning.demo.commonmistakes.springpart1.CircleDependence.constructor_wrong;

import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2020/5/16
 */
@Component
public class ServiceA {

    private ServiceB serviceB;

    //Error creating bean with name 'serviceA':
    //Requested bean is currently in creation: Is there an unresolvable circular reference?
    public ServiceA(ServiceB serviceB){
        this.serviceB = serviceB;
        System.out.println("ServiceA constructing");
    }

    public void foo(){
        System.out.println("ServiceA foo");
        serviceB.foo();
    }
}
