package com.javalearning.demo.rabbitmq.deadletter2;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import tech.rongxin.oryx.msg.order.OrderExchange;

import java.util.Date;

@Component
@RabbitListener(bindings = {
        @QueueBinding(
                value = @Queue("test-object-queue"),
                exchange = @Exchange(name = TestObjectExchange.NAME, type = "topic"),
                key = {TestObjectMsg.ROUTE}),
})
public class NormalListener {

    @RabbitHandler
    public void handNormal(TestObjectMsg testObjectMsg){
        System.out.println("收到正常消息：" + testObjectMsg);
        System.out.println("目前时间是：" + new Date().toString());
        throw new NullPointerException();
    }
}
