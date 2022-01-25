package edu.wctc.maze.companion;

import edu.wctc.maze.io.PrintQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RobotCompanionFactory implements CompanionFactory{
    private PrintQueue printQueue;

    @Autowired
    public void setPrintQueue(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public Companion createFriendlyCompanion() {
        return new MaintenanceBot();
    }

    @Override
    public Companion createSurlyCompanion() {
        return new ParanoidAndroid();
    }
}
