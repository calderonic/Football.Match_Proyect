public class Match {
    private Team teamA;
    private Team teamB;

    public Match(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public void playMatch() {

        if (teamA.getPower() > teamB.getPower()) {
            System.out.println(teamA.getName() + " wins");
        } else if (teamA.getPower() < teamB.getPower()) {
            System.out.println(teamB.getName() + " wins");
        } else {
            System.out.println("Draw");
        }
    }
}
