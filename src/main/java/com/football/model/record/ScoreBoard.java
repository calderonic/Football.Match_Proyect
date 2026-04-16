package com.football.model.record;

public class ScoreBoard extends Record {
    private int homeGoals;
    private int awayGoals;

    public ScoreBoard(int id, int homeGoals, int awayGoals) {
        super(id);
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }
}
