package com.javalearning.demo.test.containers;

import com.javalearning.demo.test.util.CollectionData;
import com.javalearning.demo.test.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

public class CollectionDataGeneration {

    public static void main(String[] args) {
        System.out.println(new ArrayList<>(CollectionData.list(new RandomGenerator.String(9), 10)));
        System.out.println(new HashSet<>(CollectionData.list(new RandomGenerator.Integer(), 10)));
    }
}
