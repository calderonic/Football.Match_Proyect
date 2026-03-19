import model.game.Match;
import model.person.Manager;
import model.person.Person;
import model.person.Player;
import model.competition.League;
import model.competition.Season;
import model.entity.Stadium;
import model.entity.Team;
import model.record.ScoreBoard;
import model.record.Statistics;
import model.service.TransferMarket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        System.out.println("Football match");

        Season season = new Season("Season 1",2026);
        League league = new League("Champions League");

        System.out.println("Season: " + season.getYear());

        Person p1 = new Player("TestPlayer", 80, 50);
        Person p2 = new Manager("TestManager", 5);

        System.out.println(p1);
        System.out.println(p2);
    }
}