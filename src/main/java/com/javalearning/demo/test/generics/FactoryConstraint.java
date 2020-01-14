package com.javalearning.demo.test.generics;

interface FactoryI<T>{
    T create();
}
class Foo2<T>{
    T x;
    public <F extends FactoryI<T>> Foo2(F factory){
        x = factory.create();
    }
}
class IntegerFactory implements FactoryI<Integer>{

    @Override
    public Integer create() {
        return new Integer(0);
    }
}
class Wight{
    static class Factory implements FactoryI<Wight>{

        @Override
        public Wight create() {
            return new Wight();
        }
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        Foo2<Integer> integerFoo2 = new Foo2<Integer>(new IntegerFactory());
        Foo2<Wight> wightFoo2 = new Foo2<Wight>(new Wight.Factory());
    }
}
