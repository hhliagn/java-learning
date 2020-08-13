package com.javalearning.demo.rabbitmq.deadletter2;

import org.springframework.stereotype.Component;

@Component
public class TestObjectProducer {

    protected String exchange() {
        return TestObjectExchange.NAME;
    }
}
