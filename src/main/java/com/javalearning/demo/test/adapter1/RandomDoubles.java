package com.javalearning.demo.test.adapter1;

import java.util.Random;

public class RandomDoubles {
    private static Random random = new Random();
    public double next(){
        return random.nextDouble();
    }
}
