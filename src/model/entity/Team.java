package model.entity;

import interfaces.IPrintable;
import model.person.Player;

import java.util.ArrayList;
import java.util.Objects;

public class Team extends Entity implements IPrintable {
    private int power;
    private ArrayList<Player> players;

    public Team(String name, int power) {
        super(name);
        this.power = power;
        this.players = new ArrayList<>();
    }

    public void increasePower(int value) {
        power += value;
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
        if (!(o instanceof Team)) return false;
        Team team = (Team) o;
        return getName().equals(team.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + getName() + '\'' +
                ", power=" + power +
                '}';
    }

    @Override
    public String printInfo() {
        return toString();
    }
}
