package com.javalearning.demo.design_pattern.decorator;

public class DecoratedWindowTest {

    public static void main(String[] args) {
        Windows windowsToBeDecorate = new HorizonScrollDecorator(new VerticalScrollDecorator(new SimpleWindow()));
        System.out.println(windowsToBeDecorate.getDesc());
    }
}
