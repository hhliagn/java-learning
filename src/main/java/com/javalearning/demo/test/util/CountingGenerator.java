package com.javalearning.demo.test.util;

public class CountingGenerator {

    public static class Integer implements Generator<java.lang.Integer>{
        private int value = 0;

        @Override
        public java.lang.Integer next() {
            return value ++;
        }
    }

    static char[] chars = ("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    public static class Character implements Generator<java.lang.Character>{
        private int index = -1;
        @Override
        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }

    public static class String implements Generator<java.lang.String>{

        private int length = 7;
        Generator<java.lang.Character> cg = new Character();
        public String(){

        }
        public String(int length){
            this.length = length;
        }
        @Override
        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i < buf.length; i++) {
                buf[i] = cg.next();
            }
            return new java.lang.String(buf);
        }
    }
}
