package com.football.model.entity;

import javax.naming.Name;

public abstract class Entity {
    protected String name;

    public Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
