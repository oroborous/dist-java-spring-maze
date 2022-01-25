package edu.wctc.maze.companion;

public class ParanoidAndroid implements Companion {
    @Override
    public String playerScoreChanged(int points) {
        if (points < 0)
            return "Marvin chuckles at your misfortune.";
        return "Marvin grunts his begrudging approval.";
    }

    @Override
    public String playerGainedItem(String item) {
        return String.format("\"Just what we need, %s,\" Marvin says, sarcastically.", item);
    }


    @Override
    public String getName() {
        return "Marvin, the Paranoid Android";
    }
}
