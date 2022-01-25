package edu.wctc.maze.companion;

import edu.wctc.maze.io.PrintQueue;

public class RobotCompanionFactory implements CompanionFactory{
    private PrintQueue printQueue;

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
