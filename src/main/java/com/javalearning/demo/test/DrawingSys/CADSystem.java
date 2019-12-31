package com.javalearning.demo.test.DrawingSys;

public class CADSystem extends Shape {
    private Circle c;
    private Triangel t;
    public CADSystem(int i) {
        super(i);
        c = new Circle(1);
        t = new Triangel(1);
        System.out.println("CADSystem constructor");
    }
    public void dispose(){
        System.out.println("CADSystem dispose");
        c.dispose();
        t.dispose();
        super.dispose();
    }
}
