package edu.wctc.maze.companion;

public class MaintenanceBot implements Companion{
    @Override
    public String playerScoreChanged(int points) {
        if (points < 0)
            return "Floyd sheds an oily tear in sympathy.";
        return "Floyd claps his hands excitedly.";
    }

    @Override
    public String playerGainedItem(String item) {
        return String.format("Floyd makes 'ooh, ahh' noises as he admires the %s", item);
    }

    @Override
    public String getName() {
        return "Floyd";
    }
}
