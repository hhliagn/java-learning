package com.javalearning.demo.test.generics.Test;

class Y{
    public Y(int i){
        System.out.println(i);
    }
}
public class Test26 {
    public static <T> T create(Class<T> tClass) throws Exception {
        T t = tClass.newInstance();
        return t;
    }
}
