package com.javalearning.demo.design_pattern.decorator;

public class VerticalScrollDecorator extends WindowsDecorator {

    public VerticalScrollDecorator(Windows windowsToBeDecorate) {
        super(windowsToBeDecorate);
    }

    @Override
    public void draw() {
        super.draw();
        drawVerticalScroll();
    }

    private void drawVerticalScroll() {
        // drawVerticalScroll
    }

    @Override
    public String getDesc() {
        return super.getDesc() + ", include VerticalScroll";
    }
}
