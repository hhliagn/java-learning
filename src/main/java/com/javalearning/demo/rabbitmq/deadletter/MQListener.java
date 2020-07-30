package com.javalearning.demo.rabbitmq.deadletter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MQListener {

    @RabbitListener(queues = MQConst.workQueue)
    public void handle(String message){
        log.info("got message " + message);
        throw new NullPointerException("error");
    }

    @RabbitListener(queues = MQConst.deadQueue)
    public void handleDead(String message){
        log.info("got dead message " + message);
    }
}
