package edu.wctc;

import edu.wctc.maze.AdventureGame;
import edu.wctc.maze.io.NewlineDelimitedPrintQueue;
import edu.wctc.maze.io.PrintQueue;
import edu.wctc.maze.room.MazeConstructor;
import edu.wctc.maze.room.TowerMazeConstructor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "edu.wctc.maze")
public class MySpringApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MySpringApp.class);
        context.refresh();

        ((AdventureGame)context.getBean("adventureGame")).play();
    }

    @Bean
    public PrintQueue printQueue() {
        return new NewlineDelimitedPrintQueue();
    }

    @Bean
    public MazeConstructor mazeConstructor() {
        return new TowerMazeConstructor();
    }
}
