package com.javalearning.demo.test.generics.Test;

public class KTV {
    public static <T extends CanSing> void sing(T t){
        t.sing();
        t.beatbox();
    }

    public static void main(String[] args) {
        SomeOneCanSing someOneCanSing = new SomeOneCanSing();
        sing(someOneCanSing);
    }
}
