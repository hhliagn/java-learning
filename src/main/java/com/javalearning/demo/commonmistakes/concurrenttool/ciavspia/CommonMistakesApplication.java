package com.javalearning.demo.commonmistakes.concurrenttool.ciavspia;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import static rx.schedulers.Schedulers.test;

@Slf4j
public class CommonMistakesApplication {

    public static void main(String[] args) {
        test(new HashMap<>());
        System.out.println("=================");
        test(new ConcurrentHashMap());
    }

    public static void test(Map map){
        try {
            log.info("{}", map.putIfAbsent("test1", null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("{}", map.containsKey("test1"));

        log.info("{}", map.computeIfAbsent("test2", k -> null));
        log.info("{}", map.containsKey("test2"));

        log.info("{}",  map.putIfAbsent("test3", "test3"));
        log.info("{}", map.computeIfAbsent("test4",   k -> "test4"));

        log.info("{}", map.putIfAbsent("test5", getValue()));
        log.info("{}", map.computeIfAbsent("test6", k -> getValue()));
    }

    public static String getValue(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){

        }
        return UUID.randomUUID().toString();
    }


}

