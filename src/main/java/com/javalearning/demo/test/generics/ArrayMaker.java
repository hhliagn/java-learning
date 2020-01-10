package com.javalearning.demo.test.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {
    private Class<T> kind;
    public ArrayMaker(Class<T> kind){
        this.kind = kind;
    }
    @SuppressWarnings("unchecked")
    T[] create(int size){
        return (T[]) Array.newInstance(kind, size); //无法获得参数类型
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringArrayMaker = new ArrayMaker<>(String.class);
        String[] strings = stringArrayMaker.create(9);
        System.out.println(Arrays.toString(strings));
    }
}
