package com.javalearning.demo.redis_data_structure.utils;

import redis.clients.jedis.Jedis;

/**
 * @author lhh
 * @date 2021/5/15
 */
public class JedisUtils {

    private static Jedis jedis = new Jedis("127.0.0.1", 6379);

    public static Jedis get() {
        return jedis;
    }
}
