package com.javalearning.demo.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Main {

    @Autowired
    private ApplicationContext applicationContext;

    @Async
    public String test(String name, Integer age){
        System.out.println(name + ", " + age);
        return "done!";
    }

    @PostConstruct
    public void execute(){
        Main bean = applicationContext.getBean(Main.class);
        String ret = bean.test("梁恒辉", 24);
    }

}
