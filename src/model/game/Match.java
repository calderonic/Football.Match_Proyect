package model.game;

import model.entity.Team;

public class Match extends Game{
    private Team teamA;
    private Team teamB;

    public Match(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    @Override
    public void play() {
        if (teamA.getPower() > teamB.getPower()) {
            System.out.println(teamA.getName() + " wins");
        } else if (teamA.getPower() < teamB.getPower()) {
            System.out.println(teamB.getName() + " wins");
        } else {
            System.out.println("Draw");
        }
    }
}
