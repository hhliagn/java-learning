package com.javalearning.demo.test.inner_class.mutil_inner_class;

public class Test {
    public static void main(String[] args) {
        AAA aaa = new AAA();
        AAA.BBB bbb = aaa.new BBB();
        AAA.BBB.CCC ccc = bbb.new CCC();
        ccc.ccc();
    }
}
