package com.javalearning.demo.rabbitmq.simple_demo;

import com.javalearning.demo.rabbitmq.simple_demo.pojo.User;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = {
                @QueueBinding(
                        value = @Queue(value = "any-queue-2"),
                        exchange = @Exchange(value = "any-exchange-2",type = "topic"),
                        key = "foo.bar.#"
                )
//                ,@QueueBinding(
//                        value = @Queue(value = "any-queue2"),
//                        exchange = @Exchange(value = "any-exchange"),
//                        key = "foo.bar.#"
//                )
        })
public class MyListener {

    @RabbitHandler
    public void handleUser(User user){
        System.out.println("Received: " + user);
        //发生异常消息重新入队，不断重试
//        throw new IOException();

//        try {
//            System.out.println("Reveived: " + message);
//            throw new IOException();
//        } catch (Exception e) {
//            e.printStackTrace(); //捕获异常会消费掉消息
//        }
//        throw new AmqpRejectAndDontRequeueException("接收消息发生异常"); //抛出这个异常也会消费掉消息
    }
}
