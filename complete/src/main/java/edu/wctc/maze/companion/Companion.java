package edu.wctc.maze.companion;

public interface Companion {
    String playerScoreChanged(int points);

    String playerGainedItem(String item);

    String getName();
}
