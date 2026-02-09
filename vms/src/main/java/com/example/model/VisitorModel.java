package com.example.model;

import jakarta.servlet.ServletContext;

import java.util.ArrayList;
import java.util.List;

public class VisitorModel {
    private static VisitorModel instance = new VisitorModel();
    private List<Visitor> visitors = new ArrayList<>();
    private TicketManager manager = new TicketManager();
    private String ticketPath;

    private VisitorModel() {}

    public static VisitorModel getInstance() { return instance; }

    public void initTicketPath(ServletContext context) {
        this.ticketPath = context.getRealPath("/WEB-INF/tickets.txt");
    }

    public void add(Visitor v) {
        visitors.add(v);
        manager.add(v);
        new TicketWriterThread(v, ticketPath).start();
    }

    public List<Visitor> getAll() { return manager.getAll(); }
}
