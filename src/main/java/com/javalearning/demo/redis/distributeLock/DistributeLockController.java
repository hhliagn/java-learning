package com.javalearning.demo.redis.distributeLock;

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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequestMapping("distributeLock")
@RestController
public class DistributeLockController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("right")
    public String right() throws ExecutionException, InterruptedException {
        String data = stringRedisTemplate.opsForValue().get("hot-spot");
        if (StringUtils.isEmpty(data)){
            RLock lock = redissonClient.getLock("lock");
            //waitTime: 获取锁最多尝试 1s
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    data = stringRedisTemplate.opsForValue().get("hot-spot");
                    if (StringUtils.isEmpty(data)){
                        data = getExpensiveData();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
        return data;
    }

    private String getExpensiveData() {
        return "important data";
    }
}
