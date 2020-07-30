package com.javalearning.demo.rabbitmq.deadletter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
@RequestMapping("/deadletter")
public class DeadLetterController {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public void sendMessage(){
        log.info("send message...");
        rabbitTemplate.convertAndSend(MQConst.workExchange, MQConst.workRouteKey, atomicInteger.incrementAndGet() + "");
    }
}
