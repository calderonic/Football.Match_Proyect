package com.football.model.record;

public record ScoreBoard(int id, int homeGoals, int awayGoals) {

    public ScoreBoard {
        if (homeGoals < 0 || awayGoals < 0) {
            throw new IllegalArgumentException("Goals cannot be negative");
        }
    }
}
