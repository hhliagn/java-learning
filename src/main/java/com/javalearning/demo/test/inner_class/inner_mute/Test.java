package com.javalearning.demo.test.inner_class.inner_mute;

public class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer.getField());
        Outer.Inner inner = outer.inner();
        inner.mute(15);
        //外部类访问内部类私有成员
        System.out.println(outer.getInnerPrivate());
    }
}
