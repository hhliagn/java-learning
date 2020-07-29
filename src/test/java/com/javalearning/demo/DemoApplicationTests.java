package com.javalearning.demo;

import com.javalearning.demo.rabbitmq.RabbitMQApplication;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.AmqpConnectException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() throws Exception {
        try {
            rabbitTemplate.convertAndSend("any-queue",
                    "Hello from RabbitMQ!");
            throw new IOException();
        }
        catch (AmqpConnectException e) {
            // ignore - rabbit is not running
        }
    }
}
