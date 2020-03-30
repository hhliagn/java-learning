package com.javalearning.demo.test.arrays;

import com.javalearning.demo.test.util.Generated;

import java.util.Arrays;
import java.util.Comparator;

class CompTypeComparator implements Comparator<CompType>{

    @Override
    public int compare(CompType o1, CompType o2) {
        return o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1);
    }
}
public class ComparatorTest {
    public static void main(String[] args) {
        CompType[] array = Generated.array(new CompType[12], CompType.generator());
        System.out.println(Arrays.toString(array));

        Arrays.sort(array, new CompTypeComparator());
        System.out.println(Arrays.toString(array));
    }
}
