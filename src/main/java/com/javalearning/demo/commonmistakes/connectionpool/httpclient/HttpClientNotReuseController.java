package com.javalearning.demo.commonmistakes.connectionpool.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("httpclientnotreuse")
@Slf4j
public class HttpClientNotReuseController {

    private static CloseableHttpClient httpClient = null;

    static {
        httpClient = HttpClients.custom().setMaxConnPerRoute(1).setMaxConnTotal(1).build();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                httpClient.close();
            } catch (IOException ignored) {
            }
        }));
    }

    @GetMapping("/wrong")
    public String wrong() {
        CloseableHttpClient httpClient
                = HttpClients.custom()
                .setConnectionManager(new PoolingHttpClientConnectionManager())
                .evictIdleConnections(60, TimeUnit.SECONDS)
                .build();
        return try_with_resource(httpClient);
    }

    @GetMapping("/wrong2")
    public String wrong2(){
        try(
                CloseableHttpClient httpClient
                        = HttpClients.custom()
                        .setConnectionManager(new PoolingHttpClientConnectionManager())
                        .evictIdleConnections(60, TimeUnit.SECONDS)
                        .build();
                CloseableHttpResponse response
                        = httpClient.execute(
                        new HttpGet("http://127.0.0.1:8080/httpclientnotreuse/test"))
                ) {
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String right(){
        return try_with_resource(httpClient);
    }

    private String try_with_resource(CloseableHttpClient httpClient) {
        RequestConfig requestConfig = RequestConfig
                .custom()
                //请求连接超时时间
                .setConnectionRequestTimeout(10000)
                //连接超时时间
                .setConnectTimeout(5000)
                .build();
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8080/httpclientnotreuse/test");
        httpGet.setConfig(requestConfig);

        try (CloseableHttpResponse response
                     = httpClient.execute(httpGet)) {
            return EntityUtils.toString(response.getEntity());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/test")
    public String test(){
        return "OK";
    }
}
