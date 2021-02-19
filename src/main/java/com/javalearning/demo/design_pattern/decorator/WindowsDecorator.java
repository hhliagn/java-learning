package com.javalearning.demo.design_pattern.decorator;

public abstract class WindowsDecorator implements Windows {

    private Windows windowsToBeDecorate;

    public WindowsDecorator(Windows windowsToBeDecorate) {
        this.windowsToBeDecorate = windowsToBeDecorate;
    }

    @Override
    public void draw() {
        windowsToBeDecorate.draw();
    }

    @Override
    public String getDesc() {
        return windowsToBeDecorate.getDesc();
    }
}
