package com.javalearning.demo.commonmistakes.collection.listremove;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class listremove {

    public static void main(String[] args) {
//        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
//        log.info("original list: {}", list);
//
//        removeByIndex(1);
//        removeByValue(1);

//        removeWrong();
//        removeRight1();
        removeRight2();
    }

    private static void removeByIndex(int index){
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        list.remove(index);
        log.info("removeByIndex：{}", list);
    }

    private static void removeByValue(Integer index){
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        list.remove(index);
        log.info("removeByValue: {}", list);
    }

    private static void removeWrong(){
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        for (Integer intVal : list) {
            if (intVal.equals(2)){
                list.remove(intVal);
            }
        }
    }

    private static void removeRight1(){
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        for(Iterator iterator = list.iterator(); iterator.hasNext();){
            Integer intVal = (Integer) iterator.next();
            if (intVal.equals(2)) {
                iterator.remove();
            }
        }
    }

    private static void removeRight2(){
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        list.removeIf(i->i.equals(2));
        log.info("remove if：{}", list);
    }


}
