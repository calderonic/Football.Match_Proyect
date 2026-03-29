package main.service;

import main.expections.NotEnoughBudgetException;
import main.expections.PlayerAlreadyExistsException;
import main.model.person.Player;
import main.model.entity.Team;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransferMarket {
    private static final Logger log = LogManager.getLogger(TransferMarket.class);

    private int budget;

    public TransferMarket(int budget) {
        this.budget = budget;
    }

    public void buyPlayer(Team team, Player player) throws NotEnoughBudgetException, PlayerAlreadyExistsException {

        if (team.getPlayers().contains(player)) {
            throw new PlayerAlreadyExistsException(player.getName() + " is already in the team.");
        }

        if (budget < player.getPrice()) {
            throw new NotEnoughBudgetException("Not enough budget to buy " + player.getName());
        }
        team.addPlayer(player);
        budget -= player.getPrice();
        log.info("Player {} bought for team {}. Remaining budget: {}", player.getName(), team.getName(), budget);
    }

    public int getBudget() {
        return budget;
    }
}
