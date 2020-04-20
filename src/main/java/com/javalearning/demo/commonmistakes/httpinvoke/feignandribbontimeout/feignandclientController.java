package com.javalearning.demo.commonmistakes.httpinvoke.feignandribbontimeout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("feignandribbon")
@Slf4j
public class feignandclientController {

    @Autowired
    private Client client;

    @GetMapping("client")
    public void client(){
        long begin = System.currentTimeMillis();
        try {
            client.server();
        } catch (Exception e) {
            log.info("执行耗时：{}, 错误：{}", System.currentTimeMillis() - begin, e.getMessage());
        }

    }

    @PostMapping("server")
    public void server() throws InterruptedException {
        TimeUnit.MINUTES.sleep(10);
    }
}
