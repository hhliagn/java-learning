package com.javalearning.demo.ratelimit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserControlle {

    @GetMapping("/user/list")
    public String userList(){
        return "OK";
    }

    @GetMapping("/user1/list")
    public String user1List(){
        return "OK";
    }
}
