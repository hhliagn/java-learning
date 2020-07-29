package com.javalearning.demo.rabbitmq.compensation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

    private Integer id;
    private String name;

    // bug here
    // https://github.com/FasterXML/jackson-databind/issues/1939
    @JsonCreator
    public User(@JsonProperty("id") Integer id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
