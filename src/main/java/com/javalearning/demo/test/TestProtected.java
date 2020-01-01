package com.javalearning.demo.test;

import com.javalearning.demo.test.protected1.Game;
import com.javalearning.demo.test.protected1.Lol;

public class TestProtected {
    public static void main(String[] args) {
        //包外访问无法访问protected方法
        Game game = new Game();
        //game.play();
    }
}
