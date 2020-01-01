package com.javalearning.demo.test.upcase;

public class TestUpcase {
    public static void main(String[] args) {
        Frog frog = new Frog();
        Amphibian amphibian = (Amphibian) frog;
        //即使向上转型了，调用方法的时候还是会优先使用的导出类对象中重载的方法
        amphibian.sound();
    }
}
