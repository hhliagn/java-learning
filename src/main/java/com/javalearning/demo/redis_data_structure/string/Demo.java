package com.javalearning.demo.redis_data_structure.string;

import com.javalearning.demo.redis_data_structure.utils.JedisUtils;
import redis.clients.jedis.Jedis;

/**
 * @author lhh
 * @date 2021/5/15
 */
public class Demo {

    /**
     * KV模型，可以是str,也可以是int
     * int情况可以原子累加，可以用于阈值判断
     */
    public static void main(String[] args) {
        Jedis jedis = JedisUtils.get();

        String testStrKv = "testStrKv";
        jedis.set(testStrKv, "val");

        System.out.println("testStrKv: " + jedis.get(testStrKv));

        String testIntKv = "testIntKv";
        jedis.set(testIntKv, "0");

        for (int i = 0; i < 10; i++) {
            jedis.incrBy(testIntKv, 1);
        }

        System.out.println("testIntKv: " + jedis.get(testIntKv));
    }
}
