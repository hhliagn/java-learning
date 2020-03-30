package com.javalearning.demo.test.arrays;

import com.javalearning.demo.test.util.ConvertTo;
import com.javalearning.demo.test.util.CountingGenerator;
import com.javalearning.demo.test.util.Generated;

import java.util.Arrays;

public class PrimitiveConversionDemonstration {

    public static void main(String[] args) {
        Integer[] a = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        int[] primitive = ConvertTo.primitive(a);
        System.out.println(Arrays.toString(primitive));
    }
}
