package com.javalearning.demo.test.generics;

import java.util.HashMap;
import java.util.Map;

class Building{

}
class House extends Building{

}
public class ClassTypeCapture<T> {
    Class<T> kind;
    Map<String,Class<T>> typeMap = new HashMap<>();

    public void addType(String name, Class<T> type){
        typeMap.put(name, type);
    }

    @SuppressWarnings("unchecked")
    public <T> T createNew(String typeName){
        Class<T> tClass = (Class<T>) typeMap.get(typeName);
        try {
            T t = tClass.newInstance();
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ClassTypeCapture(Class<T> kind){
        this.kind = kind;
    }
    public boolean f(Object arg){
        return this.kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> classTypeCapture = new ClassTypeCapture<Building>(Building.class);
        System.out.println(classTypeCapture.f(new Building()));
        System.out.println(classTypeCapture.f(new House()));

        ClassTypeCapture<House> classTypeCapture1 = new ClassTypeCapture<>(House.class);
        System.out.println(classTypeCapture1.f(new Building()));
        System.out.println(classTypeCapture1.f(new House()));
    }


}
