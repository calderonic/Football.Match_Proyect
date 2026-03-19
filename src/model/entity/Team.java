package model.entity;

import model.person.Player;

import java.util.ArrayList;
import java.util.Objects;

public class Team extends Entity {
    private int power;
    private ArrayList<Player> players;

    public Team(String name, int power, ArrayList<Player> players) {
        super(name);
        this.power = power;
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
        power += player.getSkill();
    }

    public int getPower() {
        return power;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return power == team.power && Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, players);
    }

    @Override
    public String toString() {
        return "Team{" +
                "power=" + power +
                ", players=" + players +
                ", name='" + name + '\'' +
                '}';
    }
}
