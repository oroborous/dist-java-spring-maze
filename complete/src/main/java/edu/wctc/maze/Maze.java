package edu.wctc.maze;

import edu.wctc.maze.exception.InvalidActionException;
import edu.wctc.maze.exception.NoAdjoiningRoomException;
import edu.wctc.maze.io.PrintQueue;
import edu.wctc.maze.room.MazeConstructor;
import edu.wctc.maze.room.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Maze {
    private Room currentRoom;

    private Player player;
    private PrintQueue printQueue;

    @Autowired
    public Maze(MazeConstructor mazeConstructor,
                Player player,
                PrintQueue printQueue) {
        currentRoom = mazeConstructor.createMaze();

        this.player = player;
        this.printQueue = printQueue;
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String getCurrentRoomName() {
        return currentRoom.getName().toUpperCase();
    }

    public String getCurrentRoomPossibleDirections() {
        return currentRoom.getPossibleDirections();
    }

    public int getScore() {
        return player.getScore();
    }

    public boolean isPlaying() {
        return player.isPlaying();
    }

    public void performAction(char action) {
        switch (action) {
            case 'u':
            case 'd':
            case 'w':
            case 'e':
            case 's':
            case 'n':
                try {
                    printQueue.enqueue("You leave the " + currentRoom.getName());

                    currentRoom = currentRoom.getAdjoiningRoom(action);
                } catch (NoAdjoiningRoomException e) {
                    printQueue.enqueue(e.getMessage());
                }
                break;
            case 'v':
                printQueue.enqueue(player.getInventory());
                break;
            case 'r': // 'r' recruit companion
                printQueue.enqueue(currentRoom.recruitCompanion(player));
                break;
            default:
                // 'x' exit
                // 'l' loot
                // 'i' interact
                try {
                    printQueue.enqueue(currentRoom.performAction(action, player));
                } catch (InvalidActionException e) {
                    printQueue.enqueue(e.getMessage());
                }
                break;
        }
    }
}
