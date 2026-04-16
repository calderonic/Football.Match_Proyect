package com.football.model.competition;

public abstract class Competition {
    protected String name;

    public Competition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
