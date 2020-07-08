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
        System.out.println("---------------");
        test(new ConcurrentHashMap());
    }

    public static void test(Map map){
        try {
            map.putIfAbsent("test1", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map.containsKey("test1"));

        System.out.println("=====");

        map.computeIfAbsent("test2", k -> null);
        System.out.println(map.containsKey("test2"));

        System.out.println("=====");

        System.out.println(map.putIfAbsent("test3", "test3"));
        System.out.println(map.computeIfAbsent("test4", k -> "test4"));

        System.out.println("=====");
    }

    public static String getValue(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){

        }
        return UUID.randomUUID().toString();
    }

    //pia 始终返回null 旧值，cia始终返回新值
    //HashMap 的 pia 可以 set null value , concurrentHashMap 的 pia 不可以 set null value

}

