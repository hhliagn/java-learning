package com.javalearning.demo.design_pattern.state.demo1;

public class Context {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void write(String message){
        this.state.write(message);
    }
}
