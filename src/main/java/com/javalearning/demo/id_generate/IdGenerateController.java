package com.javalearning.demo.id_generate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @description
 * @date 2020/5/11
 */
@RestController
public class IdGenerateController {

    @Autowired
    private IdGenerateService idGenerateService;

    @GetMapping("/id")
    public String id(){
        return idGenerateService.id();
    }
}
