package com.javalearning.demo.commonmistakes.serialization.deserializationconstructor;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class APIResultRight {
    private boolean success;
    private int code;

    public APIResultRight() {
        System.out.println("calling APIResultRight no-Args constructor");
    }

    @JsonCreator
    public APIResultRight(@JsonProperty("code") int code) {
        System.out.println("calling APIResultRight no-Args constructor");
        this.code = code;
        if (code == 2000) success = true;
        else success = false;
    }
}
