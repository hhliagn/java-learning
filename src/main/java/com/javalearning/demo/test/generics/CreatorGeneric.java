package com.javalearning.demo.test.generics;

abstract class GenericWithCreate<T>{
    final T element;
    public GenericWithCreate(){
        element = create();
    }
    abstract T create();
}
class X{
    public X(int i){
        System.out.println(i);
    }
}
class Creator extends GenericWithCreate<X>{

    @Override
    X create() {
        return new X(10);
    }
    public void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}
public class CreatorGeneric{
    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.f();
    }
}
