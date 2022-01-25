package edu.wctc.maze.io;

public class NewlineDelimitedPrintQueue implements PrintQueue {
    private StringBuilder stringBuilder = new StringBuilder();

    public void enqueue(String text) {
        stringBuilder.append(text);
        stringBuilder.append("\n");
    }

    public String flush() {
        String output = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        return output;
    }
}
