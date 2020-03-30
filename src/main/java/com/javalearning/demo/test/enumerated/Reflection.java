package com.javalearning.demo.test.enumerated;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

enum Explore{
    HERE, THERE
}
public class Reflection {

    public static Set<String> infos(Class<? extends Enum> clazz){
        System.out.println("----------------------------------");
        System.out.println("print interfaces...");
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            System.out.println(genericInterface);
        }

        System.out.println("Base Type: " + clazz.getSuperclass());

        System.out.println("Methods: ");
        TreeSet<String> strings = new TreeSet<>();

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            strings.add(name);
        }
        System.out.println(strings);
        return strings;
    }

    public static void main(String[] args) {
        Set<String> infos = Reflection.infos(Enum.class);
        Set<String> infos1 = Reflection.infos(Explore.class);

        System.out.println("Explore containsAll Enum ? " + infos1.containsAll(infos));

        boolean b = infos1.removeAll(infos);
        System.out.println("Explore removeAll Enum: " + infos1);

        System.out.println();
    }
}
