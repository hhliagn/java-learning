package com.javalearning.demo.test.generics.ConvariantReturnType;

interface SelfBoundSetter<T extends SelfBoundSetter<T>>{
    void set(T args);
}
interface Setter extends SelfBoundSetter<Setter>{

}
public class SelfBoundingAndConvariantArguments { //自限定类型
    void testA(Setter s1, Setter s2, SelfBoundSetter sbs){
        s1.set(s2);
//        s1.set(sbs);
    }
}
