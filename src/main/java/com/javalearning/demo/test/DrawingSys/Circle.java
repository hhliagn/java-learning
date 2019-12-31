package com.javalearning.demo.test.DrawingSys;

public class Circle extends Shape{
    public Circle(int i) {
        super(i);
        System.out.println("circle constructor");
    }
    public void dispose(){
        System.out.println("circle dispose");
        //基类的清理要和构建的顺序相反，保证基类存活到最后
        super.dispose();
    }
}
