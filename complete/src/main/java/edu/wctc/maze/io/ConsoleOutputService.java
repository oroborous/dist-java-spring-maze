package edu.wctc.maze.io;

import org.springframework.stereotype.Component;

@Component
public class ConsoleOutputService implements OutputService {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
