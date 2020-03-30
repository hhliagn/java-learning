package com.javalearning.demo.test.util;

public class ConvertTo {
    public static int[] primitive(Integer[] in){
        int[] result = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            result[i] = in[i];
        }
        return result;
    }

    //...略
}
