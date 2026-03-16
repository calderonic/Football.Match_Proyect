public class Team {
    private String name;
    private int teamPower;

    public Team(String name, int teamPower) {
        this.name = name;
        this.teamPower = teamPower;
    }

    public String getName() {
        return name;
    }

    public int getTeamPower() {
        return teamPower;
    }

    public void setTeamPower(int teamPower) {
        this.teamPower = teamPower;
    }
}
