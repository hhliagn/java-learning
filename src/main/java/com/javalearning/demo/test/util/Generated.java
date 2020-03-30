package com.javalearning.demo.test.util;

public class Generated {

    //Fill an existing Array
    public static <T> T[] array(T[] a, Generator<T> gen){
        return new CollectionData<T>(gen, a.length).toArray(a);
    }

    //Create a new Array
    @SuppressWarnings(value = "unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size){
        T[] a = (T[]) java.lang.reflect.Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(a);
    }
}
