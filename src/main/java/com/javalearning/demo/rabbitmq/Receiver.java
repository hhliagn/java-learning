package com.javalearning.demo.rabbitmq;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    public void receiveMessage(String message) {
        System.out.println("Reveived: " + message);
        throw new AmqpRejectAndDontRequeueException("接收消息发生异常");
    }
}
