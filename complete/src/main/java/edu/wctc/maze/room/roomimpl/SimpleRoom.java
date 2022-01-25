package edu.wctc.maze.room.roomimpl;

import edu.wctc.maze.Player;
import edu.wctc.maze.exception.InvalidActionException;
import edu.wctc.maze.room.Room;

public class SimpleRoom extends Room {
    public SimpleRoom() {
        super("Simple Room",
                "'Minimalist' would be a nice way of describing this room.");
    }

    @Override
    public String performAction(char action, Player player) throws InvalidActionException {
        if (action == 'l') {
            player.addToInventory("Scraps");
            return "Wow, there were some amazing treasures hidden here... at one time.";
        } else {
            throw new InvalidActionException();
        }
    }
}
