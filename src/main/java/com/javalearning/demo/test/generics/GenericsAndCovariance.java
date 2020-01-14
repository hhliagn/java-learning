package com.javalearning.demo.test.generics;

import java.util.ArrayList;
import java.util.List;

class Fruit{

}
class Apple extends Fruit{

}
class Orange extends Fruit{

}
public class GenericsAndCovariance {
    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<Apple>();
//        flist.add(new Orange());
//        flist.add(new Apple());
//        flist.add(new Object());
//        flist.add(new Fruit());
        Fruit fruit = flist.get(0);
    }
}
