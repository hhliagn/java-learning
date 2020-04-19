package com.javalearning.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class SpringDataRedisDemo {

    @Autowired
    private RedisTemplate redisTemplate;
}
