package com.javalearning.demo.map;

import org.testng.collections.Maps;

import java.util.Map;

/**
 * @author lhh
 * @date 2021/3/12
 */
public class replaceAll {

    public static void main(String[] args) {

        Map<Object, Object> objectObjectMap = Maps.newHashMap();

        objectObjectMap.put(1,"1");
        objectObjectMap.put(2,"2");
        objectObjectMap.put(3,"3");

        System.out.println(objectObjectMap);

        objectObjectMap.replaceAll((k, v) -> "40");

        System.out.println(objectObjectMap);
    }


}
