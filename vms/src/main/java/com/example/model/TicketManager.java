package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    private List<Visitor> list = new ArrayList<>();

    public void add(Visitor person) {
        list.add(person);
    }

    public void showAllWildcard(List<? extends Person> persons) {
        for (Person p : persons) {
            System.out.println(p.displayInfo());
        }
    }

    public List<Visitor> getAll() {
        return new ArrayList<>(list);
    }
}
