package com.javalearning.demo.redis_data_structure.hash;

import com.alibaba.fastjson.JSON;
import com.javalearning.demo.redis_data_structure.utils.JedisUtils;
import lombok.Data;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.Map;

/**
 * @author lhh
 * @date 2021/5/15
 */
public class Demo {

    private static final String USER_KEY = "user:001";

    /**
     * 不用把整个对象拿出来，即可以设置特定值的场景
     */
    public static void main(String[] args) {
        Jedis jedis = JedisUtils.get();

        User user1 = new User();
        user1.setId("1");
        user1.setName("aaa");
        user1.setAge("18");

        Map user1Map = JSON.parseObject(JSON.toJSONString(user1), Map.class);

        jedis.hmset(USER_KEY, user1Map);

        System.out.println(jedis.hgetAll(USER_KEY));

        jedis.hset(USER_KEY, "name", "changed_aaa");
        System.out.println(jedis.hgetAll(USER_KEY));
    }

    @Data
    static class User {
        private String id;
        private String name;
        private String age;
    }
}