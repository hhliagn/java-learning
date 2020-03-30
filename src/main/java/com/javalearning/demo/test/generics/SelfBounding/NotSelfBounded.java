package com.javalearning.demo.test.generics.SelfBounding;

public class NotSelfBounded<T> {
    T element;
    void set(T args){
        element = args;
    }
    T get(){
        return element;
    }
}
class A1 extends NotSelfBounded<A1>{

}
class B1 extends NotSelfBounded<A1>{

}
class D1{

}
class E1 extends NotSelfBounded<D1>{
    //可以编译
}
