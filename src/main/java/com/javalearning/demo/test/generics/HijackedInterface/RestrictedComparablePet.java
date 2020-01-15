package com.javalearning.demo.test.generics.HijackedInterface;

class Hamster extends ComparablePet implements Comparable<ComparablePet>{
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}
class Gecko extends ComparablePet{
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}
public class RestrictedComparablePet {

}
