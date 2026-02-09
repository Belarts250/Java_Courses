package com.example.model;

public class Visitor extends Person {
    private int visitor_id;
    private VisitorPurpose purpose;

    public Visitor(int id, String name, int visitor_id, VisitorPurpose purpose) {
        super(id, name);
        this.visitor_id = visitor_id;
        this.purpose = purpose;
    }

    public int getVisitor_id() { return visitor_id; }
    public void setVisitor_id(int visitor_id) { this.visitor_id = visitor_id; }
    public VisitorPurpose getPurpose() { return purpose; }
    public void setPurpose(VisitorPurpose purpose) { this.purpose = purpose; }

    @Override
    public String displayInfo() {
        return "WELCOME TO OUR VISITOR MANAGEMENT SYSTEM \n" +
                "Person ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Visitor ID: " + getVisitor_id() + "\n" +
                "Purpose of Visit: " + getPurpose() + "\n";
    }
}
