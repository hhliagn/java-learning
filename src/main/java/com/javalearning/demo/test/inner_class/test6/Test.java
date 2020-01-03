package com.javalearning.demo.test.inner_class.test6;

public class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Swim someOneWhoCanSwim = outer.getSomeOneWhoCanSwim();
//        Outer.Inner inner = (Outer.Inner) someOneWhoCanSwim; //内部类private, 无法获取，被完全隐藏了。
    }
}
