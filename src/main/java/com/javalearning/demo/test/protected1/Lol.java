package com.javalearning.demo.test.protected1;

public class Lol extends Game {
    private int level = 0;
    public void improveLevel(int i){
        //可以调用因为是protected的
        play();
        level += i;
        System.out.println("level now at:" + level);
    }
    public void loadGame(){
        set("Lol");
    }
}
