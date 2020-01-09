package com.javalearning.demo.test.util;

import com.javalearning.demo.test.typeinfo.toys.pets.Pet;

import java.util.HashMap;

public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;

    public TypeCounter(Class<?> aClass) {
        this.baseType = aClass;
    }

    public void count(Object object){
        Class<?> aClass = object.getClass();
        if (!baseType.isAssignableFrom(aClass)){
            throw new RuntimeException(object + "type error: " + aClass + "should be type or subtype of " + baseType);
        }
        countClass(aClass);
    }

    public void countClass(Class<?> type){
        Integer integer = get(type);
        put(type, integer == null ? 1 : integer + 1);
        Class<?> superclass = type.getSuperclass();
        if (superclass != null && baseType.isAssignableFrom(superclass)){
            countClass(superclass);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Entry<Class<?>, Integer> classIntegerEntry : entrySet()) {
            sb.append(classIntegerEntry.getKey().getSimpleName());
            sb.append("=");
            sb.append(classIntegerEntry.getValue());
            sb.append(",");
        }
        sb.delete(sb.length() - 1 , sb.length());
        sb.append("}");
        return sb.toString();
    }
}
