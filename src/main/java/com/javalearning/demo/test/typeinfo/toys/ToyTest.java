package com.javalearning.demo.test.typeinfo.toys;

public class ToyTest {
    static void printInfo(Class cc){
        System.out.println(cc.getName());
        System.out.println(cc.isInterface());

        System.out.println(cc.getSimpleName());
        System.out.println(cc.getCanonicalName());
        System.out.println();
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.javalearning.demo.test.typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("class not found ");
            System.exit(1);
        }
        printInfo(c);
        Class[] interfaces = c.getInterfaces();
        for (Class anInterface : interfaces) {
            printInfo(anInterface);
        }

        Class superclass = c.getSuperclass();
        Object obj = null;
        try {
            obj = superclass.newInstance(); //这会调用默认构造器
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        printInfo(obj.getClass());
    }
}
