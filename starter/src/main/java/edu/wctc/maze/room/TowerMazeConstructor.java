package edu.wctc.maze.room;

import edu.wctc.maze.companion.CompanionFactory;
import edu.wctc.maze.room.roomimpl.BoringRoom;
import edu.wctc.maze.room.roomimpl.DarkRoom;
import edu.wctc.maze.room.roomimpl.SimpleRoom;

public class TowerMazeConstructor implements MazeConstructor{
    // TODO - Inject a factory with field injection
    private CompanionFactory companionFactory;

    @Override
    public Room createMaze() {
        Room startRoom = new DarkRoom();
        startRoom.setCompanion(companionFactory.createSurlyCompanion());
        Room boringRoom = new BoringRoom();
        boringRoom.setCompanion(companionFactory.createFriendlyCompanion());
        Room simpleRoom = new SimpleRoom();

        startRoom.setDown(boringRoom);
        boringRoom.setUp(startRoom);

        boringRoom.setDown(simpleRoom);
        simpleRoom.setUp(boringRoom);

        return startRoom;
    }
}
