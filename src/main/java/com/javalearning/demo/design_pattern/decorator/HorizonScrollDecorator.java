package com.javalearning.demo.design_pattern.decorator;

public class HorizonScrollDecorator extends WindowsDecorator {

    public HorizonScrollDecorator(Windows windowsToBeDecorate) {
        super(windowsToBeDecorate);
    }

    @Override
    public void draw() {
        super.draw();
        drawHorizonScroll();
    }

    private void drawHorizonScroll() {
    }

    @Override
    public String getDesc() {
        return super.getDesc() + ", include HorizonScroll";
    }
}
