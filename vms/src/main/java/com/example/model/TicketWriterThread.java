package com.example.model;

import java.io.FileWriter;
import java.io.IOException;

public class TicketWriterThread extends Thread {
    private Visitor visitor;
    private String filePath;

    public TicketWriterThread(Visitor visitor, String filePath) {
        this.visitor = visitor;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(visitor.displayInfo() + "\n");
            writer.close();
            System.out.println("Background: Ticket saved for " + visitor.getName());
        } catch (Exception e) {
            System.out.println("Thread Error: " + e.getMessage());
        }
    }
}
