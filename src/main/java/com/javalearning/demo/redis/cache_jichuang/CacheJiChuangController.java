package com.javalearning.demo.redis.cache_jichuang;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 缓存击穿：某些Key属于极端热点数据，且并发量很大的情况下，
 *  如果这个Key过期，可能会在某个瞬间出现大量的并发请求同时回源，相当于大量的并发请求直接打到了数据库
 *
 *  1. 使用redisson，限制并发数为1 （最严格）
 *  2. 使用进程内的锁进行限制，这样每一个节点都可以以一个并发回源数据库。
 *  3. 不使用锁进行限制，而是使用类似Semaphore的工具限制并发数，比如限制为10，
 *     这样既限制了回源并发数不至于太大，又能使得一定量的线程可以同时回源。
 */
@Slf4j
@RequestMapping("cache_jichuang")
@RestController
public class CacheJiChuangController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("right")
    public String right() {
        String data = stringRedisTemplate.opsForValue().get("hotsopt");
        if (StringUtils.isEmpty(data)) {
            RLock locker = redissonClient.getLock("locker");
            if (locker.tryLock()) {
                try {
                    data = stringRedisTemplate.opsForValue().get("hotsopt");
                    if (StringUtils.isEmpty(data)) {
                        data = getExpensiveData();
                        stringRedisTemplate.opsForValue().set("hotsopt", data, 5, TimeUnit.SECONDS);
                    }
                } finally {
                    locker.unlock();
                }
            }
        }
        return data;
    }

    private String getExpensiveData() {
        return "important data";
    }
}
