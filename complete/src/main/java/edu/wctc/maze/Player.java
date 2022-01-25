package edu.wctc.maze;

import edu.wctc.maze.companion.Companion;
import edu.wctc.maze.io.PrintQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Player {
    private boolean playing = true;

    private int score = 0;

    private List<String> inventory = new ArrayList<>();
    private List<Companion> companions = new ArrayList<>();

    private PrintQueue printQueue;

    @Autowired
    public void setPrintQueue(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    public void addCompanion(Companion companion) {
        companions.add(companion);
    }

    public void removeCompanion(Companion companion) {
        companions.remove(companion);
    }

    public void addToInventory(String item) {
        inventory.add(item);

        for (Companion c : companions) {
            printQueue.enqueue(c.playerGainedItem(item));
        }

    }

    public void addToScore(int points) {
        score += points;

        for (Companion c : companions) {
            printQueue.enqueue(c.playerScoreChanged(points));
        }

    }

    public String getInventory() {
        if (inventory.isEmpty()) {
            return "Your pockets are empty!";
        }

        String inv = "You are carrying: ";
        inv += String.join(", ", inventory);

        return inv;
    }

    public int getScore() {
        return score;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void quit() {
        playing = false;
    }

}
