package edu.wctc.maze.exception;

public class NoAdjoiningRoomException extends Exception {
    public NoAdjoiningRoomException(char direction) {
        super("There is no adjoining room in direction: " + direction);
    }
}
