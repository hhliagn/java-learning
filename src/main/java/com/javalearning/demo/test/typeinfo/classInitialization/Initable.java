package com.javalearning.demo.test.typeinfo.classInitialization;

public class Initable {
    public static final int staticFinal = 47;
    public static final int staticFinal2 = ClassInitialization.random.nextInt();
    static {
        System.out.println("Initable init");
    }
}
