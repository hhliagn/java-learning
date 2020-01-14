package com.javalearning.demo.test.generics;


import java.awt.*;

class HoldItem<T>{
    T item;
    public HoldItem(T item){
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
class Colored2<T extends HasColor> extends HoldItem<T>{

    public Colored2(T item) {
        super(item);
    }
    public Color color(){
        return item.getColor();
    }
}
class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T>{

    public ColoredDimension2(T item) {
        super(item);
    }
    public int getX(){
        return item.x;
    }
}
public class InheritBounds {
    public static void main(String[] args) {
        ColoredDimension2<Bound> boundColoredDimension2 = new ColoredDimension2<>(new Bound());
        boundColoredDimension2.color();
        boundColoredDimension2.getX();
    }
}
