import model.game.Match;
import model.person.Manager;
import model.person.Person;
import model.person.Player;
import model.competition.League;
import model.competition.Season;
import model.entity.Stadium;
import model.entity.Team;
import model.record.Statistics;
import model.service.TransferMarket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static model.service.LoggerConfig.log;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static {
        System.setProperty("log4j.configurationFile", "./src/resources/log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {


        System.out.println("Football match simulation");

        Season season = new Season("Season 2026", 2026);
        League league = new League("Champions League");

        System.out.println(season);
        System.out.println("League: " + league.getName());

        Team barcelona = new Team("Barcelona", 70);
        Team madrid = new Team("Real Madrid", 75);

        Manager manager = new Manager("Alexis", 10);
        System.out.println(manager);

        Player messi = new Player("Messi", 95, 100);
        Player ronaldo = new Player("Ronaldo", 93, 90);

        System.out.println(messi);
        System.out.println(ronaldo);

        messi.train();

        TransferMarket market = new TransferMarket(200);

        System.out.println("Buying players...");
        market.buyPlayer(barcelona, messi);
        market.buyPlayer(madrid, ronaldo);

        manager.manage(barcelona);

        Stadium stadium = new Stadium("Camp Nou", 90000);
        System.out.println(stadium);

        Match match = new Match(barcelona, madrid);
        match.startGame();

        Statistics stats = new Statistics(1, 0);
        stats.setMatchesPlayed(1);
        System.out.println(stats);

        // Polymorphism (Person)
        Person person = new Player("TestPlayer", 80, 50);
        System.out.println(person);

        LOGGER.info("Test file logger");
    }
}