package com.javalearning.demo.test.inner_class.test4;

public class DotNew {
    public class Inner{}

    public static void main(String[] args) {
        DotNew dotNew = new DotNew();
        DotNew.Inner inner = dotNew.new Inner();
    }
}
