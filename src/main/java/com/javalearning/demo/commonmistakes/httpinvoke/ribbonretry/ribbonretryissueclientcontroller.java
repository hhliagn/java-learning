package com.javalearning.demo.commonmistakes.httpinvoke.ribbonretry;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("ribbonretryissueclient")
@Slf4j
public class ribbonretryissueclientcontroller {

    @Autowired
    private SmsClient smsClient;

    @GetMapping("wrong")
    public String wrong(){
        log.info("client called");
        try {
            smsClient.sendSmsWrong("13600000", UUID.randomUUID().toString());
        }catch (Exception e){
            log.error("send sms fail： {}", e.getMessage());
        }
        return "done";
    }

    @GetMapping("right")
    public String right(){
        log.info("client right called");
        try {
            smsClient.sendSmsRight("13600000", UUID.randomUUID().toString());
        }catch (Exception e){
            log.error("send sms fail： {}", e.getMessage());
        }
        return "done";
    }

}
