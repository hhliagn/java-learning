package com.javalearning.demo.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming
public class Fox {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;

    public static void main(String[] args) throws JsonProcessingException {
        Fox fox = new Fox();
        fox.setBirth(new Date());
        System.out.println(new ObjectMapper().writeValueAsString(fox));
    }
}
