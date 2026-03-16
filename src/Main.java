//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("Messi", 95, 100);
        Player player2 = new Player("Ronaldo", 93, 90);

        Team teamA = new Team("Barcelona", 90);
        Team teamB = new Team("Madrid", 88);

        Manager manager = new Manager("Pep Guardiola", 10);

        TransferMarket market = new TransferMarket(200);
        market.buyPlayer(player1);

        Match match = new Match(teamA, teamB);
        match.playMatch();
    }
}