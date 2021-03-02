package com.javalearning.demo.annotation.datetime_format;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonNaming
public class Model {

    public Model(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    private LocalDateTime dateTime;
}
