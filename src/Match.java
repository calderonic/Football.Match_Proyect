public class Match {
    private Team homeTeam;
    private Team awayTeam;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void playMatch() {

        if (homeTeam.getTeamPower() > awayTeam.getTeamPower()) {
            System.out.println(homeTeam.getName() + " wins!");
        } else if (homeTeam.getTeamPower() < awayTeam.getTeamPower()) {
            System.out.println(awayTeam.getName() + " wins!");
        } else {
            System.out.println("Draw!");
        }
    }
}
