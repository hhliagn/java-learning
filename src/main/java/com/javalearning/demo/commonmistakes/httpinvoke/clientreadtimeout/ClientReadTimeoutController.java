package com.javalearning.demo.commonmistakes.httpinvoke.clientreadtimeout;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.fluent.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("clientreadtimeout")
@Slf4j
public class ClientReadTimeoutController {

    @GetMapping("/client")
    public String client() throws IOException {
        log.info("client is called");
        return Request.Get("http://127.0.0.1:8080/clientreadtimeout/server?timeout=5000")
                .connectTimeout(1000)
                .socketTimeout(2000)
                .execute()
                .returnContent()
                .asString();
    }

    @GetMapping("/server")
    public void server(@RequestParam Integer timeout){
        log.info("server is called");
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Done");
    }
}
