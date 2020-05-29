package com.javalearning.demo.commonmistakes.serialization.deserializationconstructor;

import lombok.Data;

@Data
public class APIResultWrong {
    private boolean success;
    private int code;

    public APIResultWrong() {
        System.out.println("calling APIResultWrong no-Args constructor");
    }

    public APIResultWrong(int code) {
        System.out.println("calling APIResultWrong has-Args constructor");
        this.code = code;
        if (code == 2000) success = true;
        else success = false;
    }
}
