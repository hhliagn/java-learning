package com.javalearning.demo.redis.cache_xuebeng;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 缓存雪崩：很多key在同一时间过期。
 *   1. 设置一个随机的过期时间：固定时间 + 随机时间 （推荐）
 *   2. 定时更新全部缓存数据
 */
@Slf4j
@RequestMapping("cache_xuebeng")
@RestController
public class CacheXueBengController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostConstruct
    public void init(){
        IntStream.rangeClosed(1, 1000).forEach(i -> {
            stringRedisTemplate.opsForValue().set(
                    "hot-spot-key" + i,
                    "hot-spot-value" + i,
                    30 + ThreadLocalRandom.current().nextInt(10),
                    TimeUnit.SECONDS);
        });
    }
}
