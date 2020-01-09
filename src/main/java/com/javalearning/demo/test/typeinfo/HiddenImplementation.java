package com.javalearning.demo.test.typeinfo;

import com.javalearning.demo.test.typeinfo.interfacea.A;
import com.javalearning.demo.test.typeinfo.interfacea.HiddenC;

import java.lang.reflect.Method;

public class HiddenImplementation {
    public static void main(String[] args) {
        A a = HiddenC.makeA();
        a.f();
        //无法在包外访问 C 类型
        /*if (a instanceof C){
            C c = (C) a;
        }*/
        callHiddenMethod(a, "f");
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(A a, String a1) {
        try {
            Method method = a.getClass().getMethod(a1);
            method.setAccessible(true);
            method.invoke(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
