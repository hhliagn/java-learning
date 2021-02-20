package com.javalearning.demo.design_pattern.factory;

public class Main {

    public static void main(String[] args) {

        MagicMazeGame magicMazeGame = new MagicMazeGame();
        System.out.println(magicMazeGame);

        OrdinaryMazeGame ordinaryMazeGame = new OrdinaryMazeGame();
        System.out.println(ordinaryMazeGame);
    }
}
