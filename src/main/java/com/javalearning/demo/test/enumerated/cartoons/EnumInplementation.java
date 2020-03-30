package com.javalearning.demo.test.enumerated.cartoons;

import com.javalearning.demo.test.util.Generator;

import java.util.Random;

enum CartoonCharacter implements Generator<CartoonCharacter>{
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, BOB
    ;

    private Random random = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}

public class EnumInplementation {

    public static <T> void printNext(Generator<T> generator){
        System.out.println(generator.next() + "");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}
