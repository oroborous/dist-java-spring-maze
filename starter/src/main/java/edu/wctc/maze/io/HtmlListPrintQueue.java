package edu.wctc.maze.io;

public class HtmlListPrintQueue implements PrintQueue {
    private StringBuilder stringBuilder = new StringBuilder("<ul>");

    @Override
    public void enqueue(String text) {
        stringBuilder.append("<li>");
        stringBuilder.append(text);
        stringBuilder.append("</li>");
    }

    @Override
    public String flush() {
        stringBuilder.append("</ul>");
        String output = stringBuilder.toString();
        stringBuilder = new StringBuilder("<ul>");
        return output;
    }
}
