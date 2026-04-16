package com.football.model.game;

import com.football.model.entity.Team;

public abstract class Game {
    protected Team teamA;
    protected Team teamB;

    public Game(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public void startGame() {
        System.out.println("Game started: " + teamA.getName() + " vs " + teamB.getName());
    }
}
