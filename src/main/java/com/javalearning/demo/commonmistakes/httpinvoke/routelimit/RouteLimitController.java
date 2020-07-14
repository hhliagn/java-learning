package com.javalearning.demo.commonmistakes.httpinvoke.routelimit;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;

@Slf4j
@RequestMapping("routelimit")
@RestController
public class RouteLimitController {

    static CloseableHttpClient httpClient1;
    static CloseableHttpClient httpClient2;

    static {
        httpClient1 = HttpClients.custom().setConnectionManager(new PoolingHttpClientConnectionManager()).build();
        httpClient2 = HttpClients.custom().setMaxConnPerRoute(10).setMaxConnTotal(100).build();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                httpClient1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    private Integer execute(Integer count, Supplier<CloseableHttpClient> client) throws InterruptedException {
        long begin = System.currentTimeMillis();
        AtomicInteger atomicInteger = new AtomicInteger();
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        IntStream.rangeClosed(1, count).forEach(i -> {
            threadPool.execute(() -> {
                try {
                    CloseableHttpResponse response = client.get().execute(new HttpGet("http://127.0.0.1:8080/routelimit/server"));
                    atomicInteger.addAndGet(Integer.parseInt(EntityUtils.toString(response.getEntity())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
        log.info("请求次数：{}，耗时：{} ms", atomicInteger.get(), System.currentTimeMillis() - begin);
        return atomicInteger.get();
    }

    @GetMapping("/wrong")
    public Integer wrong() throws InterruptedException {
        return execute(10, () -> httpClient1);
    }

    @GetMapping("/right")
    public Integer right() throws InterruptedException {
        return execute(10, () -> httpClient2);
    }

    @GetMapping("/server")
    public int server(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
