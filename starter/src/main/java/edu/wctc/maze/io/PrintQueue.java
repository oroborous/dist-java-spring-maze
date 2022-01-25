package edu.wctc.maze.io;


public interface PrintQueue {
    void enqueue(String text);

    String flush();
}
