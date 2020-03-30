package com.javalearning.demo.test.enumerated;


import com.javalearning.demo.test.util.Enums;

enum Activity{
    SITTING, LYING, STANDING, HOPPING, RUNNING, DOGING, JUMPING, FALLING, FLYING
}
public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Activity random = Enums.random(Activity.class);
            System.out.print(random + " ");
        }
    }
}
