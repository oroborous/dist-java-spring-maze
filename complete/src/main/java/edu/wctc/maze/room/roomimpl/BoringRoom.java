package edu.wctc.maze.room.roomimpl;

import edu.wctc.maze.Player;
import edu.wctc.maze.exception.InvalidActionException;
import edu.wctc.maze.room.Room;

public class BoringRoom extends Room {
    public BoringRoom() {
        super("Boring Room",
                "This room is totally nondescript. There is nothing to do or see here.");
    }


    @Override
    public String performAction(char action, Player player) throws InvalidActionException {
        if (action == 'x') {
            player.addToScore(100);
            player.quit();
            return "You can't get out of this boring room fast enough!";
        } else {
            throw new InvalidActionException();
        }
    }
}
