package com.javalearning.demo.commonmistakes.concurrenttool.ciavspia;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ciavspia {

    public static void main(String[] args) {
        test1(new HashMap<>());
        test1(new ConcurrentHashMap<>());
    }

    private static void test1(Map<String, String> map) {
        log.info("map class: {}", map.getClass().getSimpleName());

        try {
            log.info("putIfAbsent null value: {}", map.putIfAbsent("test1", null));
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        log.info("containsKey after putIfAbsent null value: {}", map.containsKey("test1"));
        log.info("computeIfAbsent null value: {}", map.computeIfAbsent("test2", k->null));
        log.info("containsKey after computeIfAbsent null value: {}", map.containsKey("test2"));

        log.info("putIfAbsent non-null value: {}", map.putIfAbsent("test3", "test3"));
        log.info("containsKey after putIfAbsent non-null value: {}", map.containsKey("test3"));
        log.info("computeIfAbsent non-null value: {}", map.computeIfAbsent("test4", k->"test4"));
        log.info("containsKey after computeIfAbsent non-null value: {}", map.containsKey("test4"));

        log.info("putIfAbsent expansive value: {}", map.putIfAbsent("test3", getValue()));
        log.info("computeIfAbsent expansive value: {}", map.computeIfAbsent("test4", k->getValue()));
    }

    private static String getValue() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return UUID.randomUUID().toString();
    }
}
