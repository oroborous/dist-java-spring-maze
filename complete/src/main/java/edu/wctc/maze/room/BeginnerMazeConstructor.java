package edu.wctc.maze.room;

import edu.wctc.maze.room.roomimpl.BoringRoom;
import edu.wctc.maze.room.roomimpl.DarkRoom;
import edu.wctc.maze.room.roomimpl.SimpleRoom;

public class BeginnerMazeConstructor implements MazeConstructor {
    @Override
    public Room createMaze() {
        Room startRoom = new SimpleRoom();
        Room boringRoom = new BoringRoom();
        Room darkRoom = new DarkRoom();

        startRoom.setDown(boringRoom);
        boringRoom.setUp(startRoom);

        boringRoom.setEast(darkRoom);
        darkRoom.setWest(boringRoom);

        return startRoom;
    }
}
