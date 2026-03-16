import java.util.ArrayList;

public class Team {
    private String name;
    private int power;
    private ArrayList<Player> players;

    public Team(String name, int power) {
        this.name = name;
        this.power = power;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
        power += player.getSkill();
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
