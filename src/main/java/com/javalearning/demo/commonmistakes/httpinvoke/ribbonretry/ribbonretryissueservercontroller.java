package com.javalearning.demo.commonmistakes.httpinvoke.ribbonretry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("ribbonretryissueserver")
@Slf4j
public class ribbonretryissueservercontroller {

    @GetMapping("/sendsmswrong")
    public void sendSmsWrong(@RequestParam String mobile, @RequestParam String message, HttpServletRequest request) throws InterruptedException {
        log.info("{} is call, {}=>{}", request.getRequestURL(), mobile, message);
        TimeUnit.SECONDS.sleep(5000);
    }

    @PostMapping("/sendsmsright")
    public void sendSmsRight(@RequestParam String mobile, @RequestParam String message, HttpServletRequest request) throws InterruptedException {
        log.info("{} is call, {}=>{}", request.getRequestURL(), mobile, message);
        TimeUnit.SECONDS.sleep(5000);
    }
}
