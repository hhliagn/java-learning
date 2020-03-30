package com.javalearning.demo.test.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class RecoverCADState {
    @SuppressWarnings(value = "unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));

        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();

        Line.deserialStaticState(in);

        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }
}
