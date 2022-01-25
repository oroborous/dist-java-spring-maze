package edu.wctc.maze.room.roomimpl;

import edu.wctc.maze.Player;
import edu.wctc.maze.exception.InvalidActionException;
import edu.wctc.maze.room.Room;

public class DarkRoom extends Room {
    public DarkRoom() {
        super("Dark Room",
                "This room is pitch dark. You are likely to be eaten by a grue.");
    }

    @Override
    public String performAction(char action, Player player) throws InvalidActionException {
        if (action == 'i') {
            player.addToScore(-5);
            return "Does stumbling around bumping into things count as interacting?";
        } else {
            throw new InvalidActionException();
        }
    }
}
