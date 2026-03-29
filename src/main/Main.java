package main;

import main.expections.NotEnoughBudgetException;
import main.expections.PlayerAlreadyExistsException;
import main.model.game.Match;
import main.model.person.Manager;
import main.model.person.Person;
import main.model.person.Player;
import main.model.competition.League;
import main.model.competition.Season;
import main.model.entity.Stadium;
import main.model.entity.Team;
import main.model.record.Statistics;
import main.service.TransferMarket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
        } catch (NotEnoughBudgetException e) {
            LOGGER.error("Budget issue: {}", e.getMessage());
        } catch (PlayerAlreadyExistsException e) {
            LOGGER.error("Duplicate player: {}", e.getMessage());
        }

        try {
            market.buyPlayer(madrid, ronaldo);
        } catch (NotEnoughBudgetException e) {
            LOGGER.error("Budget issue: {}", e.getMessage());
        } catch (PlayerAlreadyExistsException e) {
            LOGGER.error("Duplicate player: {}", e.getMessage());
        }

        manager.manage(barcelona);

        Stadium stadium = new Stadium("Camp Nou", 90000);
        LOGGER.info("Stadium: {}", stadium);

        Match match = new Match(barcelona, madrid);
        match.startGame();
        match.play();

        Statistics stats = new Statistics(1, 0);
        stats.setMatchesPlayed(1);

        LOGGER.info("Statistics: {}", stats);

        Person person = new Player("TestPlayer", 80, 50);
        LOGGER.info("Polymorphism: {}", person);
    }
}