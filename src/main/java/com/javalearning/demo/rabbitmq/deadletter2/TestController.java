package com.javalearning.demo.rabbitmq.deadletter2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deadletter")
public class TestController {

    @Autowired
    private TestObjectProducer testObjectProducer;

    @GetMapping("/test")
    public String test(){
        TestObjectMsg testObjectMsg = new TestObjectMsg();
        testObjectMsg.setName("my-name");
        testObjectMsg.setAge(10);
//        testObjectProducer.publish(testObjectMsg);
        return "OK";
    }
}
