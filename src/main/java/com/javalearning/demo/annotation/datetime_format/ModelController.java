package com.javalearning.demo.annotation.datetime_format;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ModelController {

    @GetMapping("/model")
    public Model get(){
        return new Model(LocalDateTime.now());
    }
}
