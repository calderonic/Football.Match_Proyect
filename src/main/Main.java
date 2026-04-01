package main;

import main.expections.NotEnoughBudgetException;
import main.expections.PlayerAlreadyExistsException;
import main.generics.MatchResult;
import main.model.game.Match;
import main.model.person.Manager;
import main.model.person.Person;
import main.model.person.Player;
import main.model.competition.League;
import main.model.competition.Season;
import main.model.entity.Stadium;
import main.model.entity.Team;
import main.model.record.Statistics;
import main.service.MatchService;
import main.service.TransferMarket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "./src/main/resources/log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.info("Football match simulation");

        Season season = new Season("Season 2026", 2026);
        League league = new League("Champions League");

        LOGGER.info("Season: {}", season);
        LOGGER.info("League: {}", league.getName());

        Team barcelona = new Team("Barcelona", 70);
        Team madrid = new Team("Real Madrid", 75);

        Manager manager = new Manager("Alexis", 10);
        LOGGER.info("Manager: {}", manager);

        Player messi = new Player("Messi", 95, 100);
        Player ronaldo = new Player("Ronaldo", 93, 90);

        LOGGER.info("Players: {}, {}", messi, ronaldo);

        messi.train();

        TransferMarket market = new TransferMarket(200);

        LOGGER.info("Buying players...");

        try {
            market.buyPlayer(barcelona, messi);
        } catch (NotEnoughBudgetException | PlayerAlreadyExistsException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            market.buyPlayer(madrid, ronaldo);
        } catch (NotEnoughBudgetException | PlayerAlreadyExistsException e) {
            LOGGER.error(e.getMessage());
        }

        manager.manage(barcelona);

        barcelona.scoreGoal(messi); // uses StatTracker<T>
        LOGGER.info("Messi goals: {}", barcelona.getGoals(messi));

        Match match = new Match(barcelona, madrid);
        match.startGame();

        MatchResult<Team> result = match.playMatch();

        if (result != null) {
            LOGGER.info("Winner: {}", result.getWinner().getName());
        } else {
            LOGGER.info("Match ended in draw");
        }

        MatchService matchService = new MatchService();
        matchService.addMatch(new Match(barcelona, madrid));
        matchService.playNextMatch();

        Statistics stats = new Statistics(1, 0);
        stats.setMatchesPlayed(1);

        LOGGER.info("Statistics: {}", stats);

        Person person = new Player("TestPlayer", 80, 50);
        LOGGER.info("Polymorphism: {}", person);
    }
}