package edu.wctc.maze.exception;

public class InvalidActionException extends Exception {
    public InvalidActionException() {
        super("You can't do that here!");
    }
}
