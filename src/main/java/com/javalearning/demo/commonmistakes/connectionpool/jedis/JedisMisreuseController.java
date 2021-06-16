package com.javalearning.demo.commonmistakes.connectionpool.jedis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("jedismisreuse")
@Slf4j
public class JedisMisreuseController {

    private static JedisPoolConfig jedisPoolConfig = null;
    private static JedisPool jedisPool = null;

    static {
        jedisPoolConfig = new JedisPoolConfig();
        ////请求连接超时时间
        jedisPoolConfig.setMaxWaitMillis(10000);
        //连接超时时间
        jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 5000);
    }

    @PostConstruct
    public void init(){
        try (Jedis jedis = new Jedis("127.0.0.1", 6379)) {
            Assert.isTrue("OK".equals(jedis.set("A", "1")), "set A = 1 return OK");
            Assert.isTrue("OK".equals(jedis.set("b", "2")), "set b = 2 return OK");
        }
    }

    @GetMapping("/wrong")
    public void wrong() throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                check(jedis, "A", "1", "expect 1 but got : {}");
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                check(jedis, "b", "2", "expect 2 but got : {}");
            }
        }).start();
        TimeUnit.SECONDS.sleep(5);
    }

    @GetMapping("/right")
    public void right(){

        new Thread(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                for (int i = 0; i < 1000; i++) {
                    check(jedis, "A", "1", "expect 1 but got : {}");
                }
            }
        }).start();
        new Thread(() -> {
            try (Jedis jedis = jedisPool.getResource()){
                for (int i = 0; i < 1000; i++) {
                    check(jedis, "b", "2", "expect 2 but got : {}");
                }
            }
        }).start();
    }

    private void check(Jedis jedis, String a, String s, String s2) {
        String result = jedis.get(a);
        if (!s.equalsIgnoreCase(result)) {
            log.warn(s2, result);
        }
    }
}
