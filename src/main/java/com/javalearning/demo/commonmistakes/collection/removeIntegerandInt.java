package com.javalearning.demo.commonmistakes.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class removeIntegerandInt {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        integerList.remove(new Integer(2));
        log.info("remove integer: {}", integerList); //remove int: [1, 2, 4, 5] 根据对象删除

        List<Integer> integerList2 = new ArrayList<>();
        integerList2.add(1);
        integerList2.add(2);
        integerList2.add(3);
        integerList2.add(4);
        integerList2.add(5);

        integerList2.remove(2);
        log.info("remove int: {}", integerList2); //remove int: [1, 2, 4, 5] 根据索引删除
    }
}
