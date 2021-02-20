package com.javalearning.demo.design_pattern.factory;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public abstract class MazeGame {

    private List<Room> rooms = new ArrayList<>();

    public MazeGame(){
        Room room1 = makeRoom();
        Room room2 = makeRoom();
        room1.connect(room2);
        rooms.add(room1);
        rooms.add(room2);
    }

    protected abstract Room makeRoom();
}
