package com.javalearning.demo.test.generics.ConvariantReturnType;

class Base{

}
class Derived extends Base{

}
interface OrdinaryGetter{
    Base get();
}
interface DerivedGetter extends OrdinaryGetter{
    Derived get();
}
public class ConvariantReturnType {
    void test(DerivedGetter d){
        Derived derived = d.get();
    }
}
