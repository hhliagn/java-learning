package com.javalearning.demo.test.protected1;

public class TestProtected {
    public static void main(String[] args) {
        Lol lol = new Lol();
        lol.loadGame();
        lol.improveLevel(100);

        //包内访问
        Game game = new Game();
        game.play();
    }
}
