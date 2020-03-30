package com.javalearning.demo.test.arrays;

import com.javalearning.demo.test.util.Generated;
import com.javalearning.demo.test.util.Generator;

import java.util.Arrays;
import java.util.Random;

public class CompType implements Comparable<CompType>{

    int i = 0;
    int j = 0;

    public CompType(int i, int j){
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "[ i = " + i + " , j = " + j + "]";
    }

    @Override
    public int compareTo(CompType ct) {
        return i < ct.i ? -1 : (i == ct.i ? 0 : 1);
    }

    private static Random r = new Random();

    public static Generator<CompType> generator(){
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(r.nextInt(1000), r.nextInt(1000));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] array = Generated.array(new CompType[10], generator());
        System.out.println(Arrays.toString(array));

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
