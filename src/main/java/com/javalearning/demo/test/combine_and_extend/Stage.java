package com.javalearning.demo.test.combine_and_extend;

public class Stage {
    private Actor actor = new HappyActor();
    public void change(Actor actor){
        this.actor = actor;
    }
    public void play(){
        actor.act();
    }
}
