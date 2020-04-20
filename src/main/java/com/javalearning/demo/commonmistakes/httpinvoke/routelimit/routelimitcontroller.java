package com.javalearning.demo.commonmistakes.httpinvoke.routelimit;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.IntStream;

@RestController
@RequestMapping("routelimit")
@Slf4j
public class routelimitcontroller {

    static CloseableHttpClient httpClient1;
    static CloseableHttpClient httpClient2;

    @PostConstruct
    public void init(){
        httpClient1 = HttpClients.custom().setConnectionManager(new PoolingHttpClientConnectionManager()).build();
        //使用同一个HttpClient访问同一个域名，最多可以支持10个并发，总共最多支持100并发，相当于10个域名都有10个并发
        httpClient2 = HttpClients.custom().setMaxConnPerRoute(10).setMaxConnTotal(100).build();

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try {
                httpClient1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    public void send(int count, Supplier<CloseableHttpClient> client) throws InterruptedException {
        long begin = System.currentTimeMillis();
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        threadPool.execute(() -> {
            IntStream.rangeClosed(1, count).forEach(i -> {
                try {
                    client.get().execute(new HttpGet("http://127.0.0.1:8080/routelimit/server"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });

        threadPool.shutdown();
        threadPool.awaitTermination(1,TimeUnit.HOURS);
        log.info("执行耗时： {}ms", System.currentTimeMillis() - begin);
    }

    @GetMapping("wrong")
    public void wrong(@RequestParam(value = "count", defaultValue = "10") int count) throws InterruptedException {
        send(count, ()-> httpClient1);
    }

    @GetMapping("right")
    public void right(@RequestParam(value = "count", defaultValue = "10") int count) throws InterruptedException {
        send(count, ()-> httpClient1);
    }

    @GetMapping("/server")
    public String server() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "1";
    }


}
