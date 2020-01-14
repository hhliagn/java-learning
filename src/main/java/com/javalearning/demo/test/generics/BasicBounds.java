package com.javalearning.demo.test.generics;

import java.awt.*;

interface HasColor{
    Color getColor();
}
class Colored<T extends HasColor>{
    T item;
    public Colored(T item){
        this.item = item;
    }
    public T getItem() {
        return item;
    }
    //边界允许你访问getColor()
    public Color color(){
        return item.getColor();
    }
}

class Dimension{
    public int x,y,z;
}

class ColoredDimension<T extends Dimension & HasColor>{
    T item;
    public ColoredDimension(T item){
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public Color color(){
        return item.getColor();
    }
    public int getX(){
        return item.x;
    }
}

class Bound extends Dimension implements HasColor{

    @Override
    public Color getColor() {
        return null;
    }
}
public class BasicBounds {

    public static void main(String[] args) {
        ColoredDimension<Bound> boundColoredDimension = new ColoredDimension<>(new Bound());
        boundColoredDimension.color();
        boundColoredDimension.getX();
    }
}
