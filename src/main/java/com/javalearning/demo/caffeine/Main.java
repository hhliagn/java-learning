package com.javalearning.demo.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.google.common.testing.FakeTicker;

import java.util.concurrent.TimeUnit;

/**
 * @author lhh
 * @date 2021/6/7
 */
public class Main {

    private static final FakeTicker TICKER = new FakeTicker();

    private static final LoadingCache<String, String> CACHE = Caffeine.newBuilder()
            .softValues()
            .initialCapacity(50)
            .maximumSize(1_000)
            .ticker(TICKER::read)
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build(key -> getVal2());

    private static String getVal1(String key) {
        return "val";
    }

    private static String getVal2() {
        return "val";
    }

    public static void main(String[] args) {

        String key = "name";

        //System.out.println("初始化");
        //String val = CACHE.get(key);
        //
        //System.out.println("第一次获取");
        //TICKER.advance(4000, TimeUnit.MILLISECONDS);
        //
        //val = CACHE.get(key);
        //
        //System.out.println("第二次获取");
        //TICKER.advance(1100, TimeUnit.SECONDS);
        //
        //val = CACHE.get(key);


        for (int i = 0; i < 10; i++) {
            CACHE.put(key + i, key + i);
        }

        CACHE.cleanUp();

        System.out.println(CACHE.asMap());

    }
}
