package edu.wctc.maze;

import edu.wctc.maze.io.InputService;
import edu.wctc.maze.io.OutputService;
import edu.wctc.maze.io.PrintQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdventureGame {
    @Autowired
    private InputService in;
    @Autowired
    private OutputService out;
    @Autowired
    private Maze maze;
    @Autowired
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
