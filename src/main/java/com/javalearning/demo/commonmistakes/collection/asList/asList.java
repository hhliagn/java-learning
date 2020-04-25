package com.javalearning.demo.commonmistakes.collection.asList;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class asList {

    public static void main(String[] args) {
//        wrong();
        wrong1();
//        right1();
    }

    private static void wrong(){
        int[] arr = new int[]{1,2,3};
        List list = Arrays.asList(arr);
        log.info("arr: {}, size: {}, class: {}", arr, list.size(), list.get(0).getClass());
    }

    private static void wrong1(){
        String[] arr = {"2","3","4"};
        List<String> list = Arrays.asList(arr);
//        arr[1] = "4";
        try {
            list.set(1,"5");
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("arr: {}, size: {}, class: {}", arr, list, list.get(0).getClass());
    }

    private static void right(){
        int[] arr = new int[]{1,2,3};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        log.info("arr: {}, size: {}, class: {}", arr, list.size(), list.get(0).getClass());

        Integer[] arr2 = new Integer[]{1,2,3};
        List<Integer> list2 = Arrays.asList(arr2);
        log.info("arr: {}, size: {}, class: {}", arr2, list2.size(), list2.get(0).getClass());
    }

    private static void right1(){
        String[] arr = {"2","3","4"};
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        arr[1] = "4";
        try {
            list.add("5");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("arr: {}, size: {}, class: {}", arr, list, list.get(0).getClass());
    }



}
