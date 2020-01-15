package com.javalearning.demo.test.generics;

public class CaptureConversion {
    static <T> void f1(Holder3<T> holder3){
        T t = holder3.get();
        System.out.println(t.getClass().getSimpleName());
    }
    static void f2(Holder3<?> holder3){
        f1(holder3);
    }

    public static void main(String[] args) {
        Holder3 holderRaw = new Holder3<>(1);
//        f1(holderRaw); //warning
        f2(holderRaw);

        Holder3 holderBasic = new Holder3<>(new Object());
        f2(holderBasic);

        Holder3<?> holderWild = new Holder3<>(1.0);
        f2(holderWild);
    }
}
