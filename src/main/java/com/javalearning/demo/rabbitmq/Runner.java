package com.javalearning.demo.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Receiver receiver;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("sending message...");
        rabbitTemplate.convertAndSend(RabbitMQApplication.exchange, "foo.bar.zar", "Hello from RabbitMQ!");
    }
}
