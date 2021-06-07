package com.javalearning.demo.redis_data_structure.list;

import com.javalearning.demo.redis_data_structure.utils.JedisUtils;
import lombok.SneakyThrows;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author lhh
 * @date 2021/5/15
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {

        Jedis jedis = JedisUtils.get();

        jedis.lpush("list2", "2aaa", "2bbb", "2ccc");
        jedis.lpush("list3", "3aaa", "3bbb", "3ccc");

        List<String> list = null;

        Runnable runnable = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("xxx");
            jedis.lpush("list3", "3ddd", "3eee", "3fff");
        };

        Thread thread = new Thread(runnable);
        thread.start();

        while (true) {
            if ((list = jedis.blpop(1, "list1", "list2", "list3")) != null) {
                System.out.println(list);
            }
        }
    }
}
