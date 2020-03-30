package com.javalearning.demo.test.generics.SelfBounding;

class SelfBounded<T extends SelfBounded<T>> {
    T element;
    void set(T args){
        element = args;
    }
    T get(){
        return element;
    }
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}

class A extends SelfBounded<A>{

}
class B extends SelfBounded<A>{

}
class C extends SelfBounded<C>{
    C setAndGet(C arg){
        set(arg);
        return get();
    }
}
class D{

}
//class E extends SelfBounded<D>{ //error
//  不可以编译不在基类中的类型
//}

class F extends SelfBounded{

}

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
        B b = new B();
        A a1 = b.get(); //这里返回的还是A
    }
}
