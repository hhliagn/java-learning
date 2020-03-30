package com.javalearning.demo.test.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


abstract class Shape implements Serializable{
    protected static final int RED = 1, BLUE = 2, GREEN = 3;
    private int x, y, dim;

    private static Random random = new Random(47);
    private static int counter = 0;

    public abstract int getColor();
    public abstract void setColor(int newColor);

    public Shape(int x, int y, int dim) {
        this.x = x;
        this.y = y;
        this.dim = dim;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "Color[" + getColor() + "]" +
                "x=" + x +
                ", y=" + y +
                ", dim=" + dim +
                '}';
    }

    public static Shape randomFactory(){
        int x = random.nextInt(100);
        int y = random.nextInt(100);
        int dim = random.nextInt(100);

        switch (counter ++ % 3){
            default:
            case 0: return new Circle(x,y,dim);
            case 1: return new Square(x,y,dim);
            case 2: return new Line(x,y,dim);
        }
    }

}

class Circle extends Shape{

    private static int color = RED;

    public Circle(int x, int y, int dim) {
        super(x, y, dim);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
}

class Square extends Shape{

    private static int color;

    public Square(int x, int y, int dim) {
        super(x, y, dim);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
}

class Line extends Shape{

    private static int color = RED;

    public Line(int x, int y, int dim) {
        super(x, y, dim);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    public static void serialStaticState(ObjectOutputStream out) throws IOException {
        out.writeInt(color);
    }

    public static void deserialStaticState(ObjectInputStream in) throws IOException {
        color = in.readInt();
    }

}


public class StoreCADState {

    public static void main(String[] args) throws IOException {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();

        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);

        List<Shape> shapes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactory());
        }

        for (int i = 0; i < 10; i++) {
            Shape shape = shapes.get(i);
            shape.setColor(Shape.GREEN);
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));

        out.writeObject(shapeTypes);

        Line.serialStaticState(out);

        out.writeObject(shapes);

        System.out.println(shapes);
    }
}
