package com.javalearning.demo.test.inner_class.controll_framework;

public abstract class Event {
    private long eventTime;
    protected long delayTime;
    public Event(long delayTime){
        this.delayTime = delayTime;
        start();
    }
    public void start(){
        this.eventTime = System.nanoTime() + delayTime;
    }
    public boolean ready(){
        return System.nanoTime() >= eventTime;
    }
    public abstract void action();
}
