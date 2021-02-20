package com.javalearning.demo.design_pattern.factory;

import lombok.ToString;

@ToString(callSuper = true)
public class MagicMazeGame extends MazeGame {

    @Override
    protected Room makeRoom() {
        return new MagicRoom();
    }
}
