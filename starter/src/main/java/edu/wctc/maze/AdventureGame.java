package edu.wctc.maze;

import edu.wctc.maze.io.InputService;
import edu.wctc.maze.io.OutputService;
import edu.wctc.maze.io.PrintQueue;


public class AdventureGame {
    // TODO - Inject these four fields with field injection
    private InputService in;
    private OutputService out;
    private Maze maze;
    private PrintQueue printQueue;

    public void play() {
        while (maze.isPlaying()) {
            out.print(maze.getCurrentRoomName());

            out.print(maze.getCurrentRoomDescription());

            out.print(maze.getCurrentRoomPossibleDirections());

            char command = in.getInput();
            maze.performAction(command);

            out.print(printQueue.flush());
        }

        out.print("GAME OVER");
        out.print("Score: " + maze.getScore());
    }
}
