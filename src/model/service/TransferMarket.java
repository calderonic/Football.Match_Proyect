package model.service;

import model.person.Player;
import model.entity.Team;

public class TransferMarket {
    private int budget;
    public TransferMarket(int budget) {
        this.budget = budget;
    }

    public void buyPlayer(Team team, Player player) {

        if (budget >= player.getPrice()) {
            team.addPlayer((Player) player);
            budget -= player.getPrice();
            System.out.println("Player bought. Remaining budget: " + budget);
        } else {
            System.out.println("Not enough budget");
        }
    }
}
