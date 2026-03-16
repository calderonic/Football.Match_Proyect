//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        System.out.println("Football match simulation");

        Season season = new Season(2026);
        System.out.println("Season year: " + season.getYear());

        League league = new League("Champions League");
        System.out.println("League: " + league.getName());

        Team barcelona = new Team("Barcelona", 70);
        Team madrid = new Team("Real Madrid", 75);

        Manager manager = new Manager("Alexis", 10);
        System.out.println("Manager name: " + manager.getName());

        Player messi = new Player("Messi", 95, 100);
        Player ronaldo = new Player("Ronaldo", 93, 90);

        TransferMarket transferMarket = new TransferMarket(200);

        System.out.println("Buying players");
        transferMarket.buyPlayer(barcelona, messi);
        transferMarket.buyPlayer(madrid, ronaldo);

        Stadium stadium = new Stadium("Camp Nou", 90000);
        System.out.println("Stadium: " + stadium.getName());

        ScoreBoard scoreBoard = new ScoreBoard(0, 0);
        System.out.println("Score: " + scoreBoard.getHomeGoals() + "-" + scoreBoard.getAwayGoals());

        Match match = new Match(barcelona, madrid);
        match.playMatch();

        Statistics statistics = new Statistics(0);
        statistics.setMatchesPlayed(1);

        System.out.println("Matches played: " + statistics.getMatchesPlayed());
    }
}