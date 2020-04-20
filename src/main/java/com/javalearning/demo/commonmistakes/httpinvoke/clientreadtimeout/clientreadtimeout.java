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
public class clientreadtimeout {

    private String getResponse(String uri, int connectTimeout, int readTimeout) throws IOException {
        return Request.Get("http://127.0.0.1:8080/clientreadtimeout" + uri)
                .connectTimeout(connectTimeout)
                .socketTimeout(readTimeout)
                .execute()
                .returnContent()
                .asString();
    }

    @GetMapping("/client")
    public String client() throws IOException {
        log.info("client called");
        return getResponse("/server?timeout=5000", 1000, 2000);
    }

    @GetMapping("/server")
    public void server(@RequestParam int timeout) throws InterruptedException {
        log.info("server called");
        TimeUnit.MILLISECONDS.sleep(timeout);
        log.info("Done");

    }
}
