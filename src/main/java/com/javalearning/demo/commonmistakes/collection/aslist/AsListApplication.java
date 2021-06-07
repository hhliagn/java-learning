package com.javalearning.demo.commonmistakes.collection.aslist;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class AsListApplication {

    public static void main(String[] args) {
        wrong();
        System.out.println();
        wrong2();
        System.out.println();
        right();
        System.out.println();
        right2();
    }

    private static void wrong(){
        int [] arr = new int[]{1,2,3};
        List<int[]> ints = Arrays.asList(arr);
        log.info("hash: {}, hash size:{}, hash class:{}", ints, ints.size(), ints.get(0).getClass());
    }

    private static void wrong2(){
        Integer[] arr = new Integer[]{1,2,3};
        List<Integer> integers = Arrays.asList(arr);
        arr[1] = 4;
        try {
            integers.add(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("hash:{}, arr:{}", integers, Arrays.toString(arr));
    }

    private static void right(){
        Integer[] arr = new Integer[]{1,2,3};
        List<Integer> integers = Arrays.asList(arr);
        log.info("hash: {}, hash size:{}, hash class:{}",
                integers, integers.size(), integers.get(0).getClass());
    }

    private static void right2(){
        Integer[] arr = new Integer[]{1,2,3};
        List<Integer> integers = new ArrayList<>(Arrays.asList(arr));
        arr[1] = 4;
        try {
            integers.add(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("hash:{}, arr:{}", integers, Arrays.toString(arr));
    }
}

