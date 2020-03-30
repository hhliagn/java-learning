package com.javalearning.demo.test.util;

import java.util.Random;

public class RandomGenerator {
    private static Random r = new Random();
    public static class Integer implements Generator<java.lang.Integer>{
        public int mod = 1000;
        public Integer(){

        }
        public Integer(int mod){
            this.mod = mod;
        }
        @Override
        public java.lang.Integer next() {
            return r.nextInt(mod);
        }
    }

    public static class Character implements Generator<java.lang.Character>{

        @Override
        public java.lang.Character next() {
            return CountingGenerator.chars[r.nextInt(CountingGenerator.chars.length)];
        }
    }

    public static class String extends CountingGenerator.String{

        {
            cg = new Character();
        }

        public String(int length){
            super(length);
        }
    }
}
