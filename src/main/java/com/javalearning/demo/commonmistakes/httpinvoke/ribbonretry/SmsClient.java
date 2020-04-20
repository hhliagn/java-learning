package com.javalearning.demo.commonmistakes.httpinvoke.ribbonretry;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("SmsClient")
public interface SmsClient {

    @GetMapping("ribbonretryissueserver/sendsmswrong")
    void sendSmsWrong(@RequestParam String mobile, @RequestParam String message);

    @PostMapping("ribbonretryissueserver/sendsmsright")
    void sendSmsRight(@RequestParam String mobile, @RequestParam String message);
}
