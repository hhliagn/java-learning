package com.javalearning.demo.test.typeinfo.toys.FamilyVSExactType;

public class FamilyVSExactType {
    static void test(Object x){
        System.out.println("x 's type" + x.getClass());
        System.out.println("x instanceOf base: " + (x instanceof Base));
        System.out.println("Base isInstance x: " + (Base.class.isInstance(x)));

        System.out.println("x instanceOf derived: " + (x instanceof Derived));
        System.out.println("Derived isInstance x: " + (Derived.class.isInstance(x)));

        System.out.println("x class == Base class: " + (x.getClass() == Base.class));
        System.out.println("x class == Drived class: " + (x.getClass() == Derived.class));

        System.out.println("x class equals Base class: "+(x.getClass().equals(Base.class)));
        System.out.println("x class equals Derived class: "+(x.getClass().equals(Derived.class)));
    }

    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
}
