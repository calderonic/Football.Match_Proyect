package model.game;

import interfaces.IPlayable;
import model.entity.Team;

public class Match extends Game implements IPlayable {
    public Match(Team teamA, Team teamB) {
        super(teamA, teamB);
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
