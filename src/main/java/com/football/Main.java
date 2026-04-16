package com.football;

import com.football.expections.PlayerAlreadyExistsException;
import com.football.interfaces.PlayerAction;
import com.football.interfaces.PlayerFilter;
import com.football.model.competition.League;
import com.football.model.competition.Season;
import com.football.model.entity.Team;
import com.football.model.game.Match;
import com.football.model.person.Manager;
import com.football.model.person.Person;
import com.football.model.person.Player;
import com.football.model.record.Statistics;
import com.football.service.FileWordCounter;
import com.football.expections.NotEnoughBudgetException;
import com.football.generics.MatchResult;
import com.football.service.MatchService;
import com.football.service.TransferMarket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

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
        barcelona.getPlayers().stream().forEach(p -> LOGGER.info("Player: {}", p.getName()));

        PlayerFilter highSkill = p -> p.getSkill() > 90;
        barcelona.getPlayers().stream().filter(highSkill::test).forEach(p -> LOGGER.info("Top player: {}", p.getName()));

        PlayerAction trainPlayer = p -> p.train();

        barcelona.getPlayers().forEach(trainPlayer::apply);

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

        try {
            FileWordCounter.processFile(
                    "src/main/resources/input.txt",
                    "src/main/resources/output.txt"
            );
        } catch (Exception e) {
            LOGGER.error("File processing error: {}", e.getMessage());
        }
    }
}