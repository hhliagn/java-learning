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

@Slf4j
@RequestMapping("jedismisreuse")
@RestController
public class Jedismisreuse {

    private static JedisPool jedisPool = new JedisPool("127.0.0.1",6379);

    @PostConstruct
    public void init(){
        try(Jedis jedis = new Jedis("127.0.0.1",6379)){
            Assert.isTrue("OK".equals(jedis.set("a","1")), "set a = 1 return OK");
            Assert.isTrue("OK".equals(jedis.set("b","2")), "set b = 2 return OK");
        }
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            jedisPool.close();
        }));
    }

    @GetMapping("/wrong")
    public void wrong() throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                String rs = jedis.get("a");
                if (!"1".equals(rs)){
                    log.warn("expect to be 1 but found {}", rs);
                    return;
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                String rs = jedis.get("b");
                if (!"2".equals(rs)){
                    log.warn("expect to be 2 but found {}", rs);
                    return;
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(5);
    }

    @GetMapping("/right")
    public void right(){
        new Thread(()->{
            try(Jedis jedis = jedisPool.getResource()){
                for (int i = 0; i < 1000; i++) {
                    String rs = jedis.get("a");
                    if (!"1".equals(rs)){
                        log.warn("expect to be 1 but found {}", rs);
                        return;
                    }
                }
            }
        }).start();
        new Thread(()->{
            try(Jedis jedis = jedisPool.getResource()){
                for (int i = 0; i < 1000; i++) {
                    String rs = jedis.get("b");
                    if (!"2".equals(rs)){
                        log.warn("expect to be 2 but found {}", rs);
                        return;
                    }
                }
            }
        }).start();
    }

    @GetMapping("/timeout")
    public String timeout(@RequestParam int waittimeout,
                          @RequestParam int connecttimeout){

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1);
        jedisPoolConfig.setMaxWaitMillis(waittimeout);
        try (JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, connecttimeout);
             Jedis jedis = jedisPool.getResource()){

            return jedis.set("test","test");
        }
    }

}
