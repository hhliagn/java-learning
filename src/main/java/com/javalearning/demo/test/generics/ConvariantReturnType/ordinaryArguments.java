package com.javalearning.demo.test.generics.ConvariantReturnType;

class OrdinarySetter{
    void set(Base base){
        System.out.println("OrdinarySetter.set()");
    }
}
class DerivedSetter extends OrdinarySetter{
    void set(Derived derived){
        System.out.println("DerivedSetter.set()");
    }
}
public class ordinaryArguments { //非泛型
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedSetter ds = new DerivedSetter();
        ds.set(base); //这是重写，不是重载，还保留着父类中的方法
        ds.set(derived);
    }
}
