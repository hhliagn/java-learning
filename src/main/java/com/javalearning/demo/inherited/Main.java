package com.javalearning.demo.inherited;

public class Main {

    /**
     * @Inherited 被该注解注解的注解用在类上面，该注解可以被子类继承
     */
    public static void main(String[] args) {
        Class<Child> childClass = Child.class;
        boolean annotationPresent = childClass.isAnnotationPresent(MyAnno.class);
        System.out.println(annotationPresent);
    }
}
