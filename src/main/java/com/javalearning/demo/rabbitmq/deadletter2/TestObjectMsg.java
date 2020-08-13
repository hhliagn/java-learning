package com.javalearning.demo.rabbitmq.deadletter2;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import tech.rongxin.oryx.amqp.OryxMsgIf;

@Data
@JsonNaming
public class TestObjectMsg implements OryxMsgIf {
    public final static String ROUTE = "test-object-route";
    public final static String DEAD_ROUTE = "test-object-dead-route";

    private String name;
    private Integer age;

    @Override
    public String route() {
        return "test-object-route";
    }
}
