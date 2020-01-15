package com.javalearning.demo.test.generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Shape{
    public void rotate(){
        System.out.println(this + "rotate");
    }
    public void resize(int newsize){
        System.out.println(this + " resize " + newsize);
    }

    @Override
    public String toString() {
        return "Shape";
    }
}
class Square extends Shape{
    @Override
    public String toString() {
        return "Square";
    }
}
class FilledList<T> extends ArrayList<T>{
    public FilledList(Class<? extends T> type, int size){
        try{
            for (int i = 0; i < size; i++) {
                add(type.newInstance());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
public class Apply {
    public static <T, S extends Iterable<T>> void apply(S seq , Method m, Object...args){
        for (T t : seq) {
            try {
                m.invoke(t, args);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class SimpleQueue<T> implements Iterable<T>{
    private LinkedList<T> storage = new LinkedList<T>();

    public void add(T t){
        storage.offer(t);
    }

    public T get(){
        return storage.poll();
    }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}
class ApplyTest{
    public static void main(String[] args) throws Exception {
        List<Shape> shapes = new ArrayList<Shape>();
        for (int i = 0; i < 10; i++) {
            shapes.add(new Shape());
        }
        Apply.apply(shapes, Shape.class.getMethod("rotate"));
        Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);

        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            squares.add(new Square());
        }
        Apply.apply(squares, Square.class.getMethod("rotate"));
        Apply.apply(squares, Square.class.getMethod("resize", int.class), 5);

        Apply.apply(new FilledList<Shape>(Shape.class, 10), Shape.class.getMethod("rotate"));
        Apply.apply(new FilledList<Square>(Square.class, 10), Square.class.getMethod("rotate"));

        SimpleQueue shapeQ = new SimpleQueue();
        for (int i = 0; i < 5; i++) {
            shapeQ.add(new Shape());
            shapeQ.add(new Square());
        }
        Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
    }
}
