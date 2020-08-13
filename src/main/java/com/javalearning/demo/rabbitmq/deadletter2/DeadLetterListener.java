package com.javalearning.demo.rabbitmq.deadletter2;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RabbitListener(bindings = {
        @QueueBinding(
                value = @Queue("test-object-dead-queue"),
                exchange = @Exchange(name = TestObjectDeadExchange.NAME, type = "topic"),
                key = {TestObjectMsg.DEAD_ROUTE}),
})
public class DeadLetterListener {

    @RabbitHandler
    public void handTestMsgFail(TestObjectMsg testObjectMsg){
        System.out.println("收到死信消息: " + testObjectMsg);
        System.out.println("目前时间是：" + new Date().toString());
    }

}
