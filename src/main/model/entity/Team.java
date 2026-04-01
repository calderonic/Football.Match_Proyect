package main.model.entity;

import main.generics.Squad;
import main.generics.StatTracker;
import main.interfaces.IPrintable;
import main.model.person.Player;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class Team extends Entity implements IPrintable {
    private int power;
    private Squad<Player> squad;
    private StatTracker<Player> goals;

    public Team(String name, int power) {
        super(name);
        this.power = power;
        this.squad = new Squad<>();
        this.goals = new StatTracker<>();
    }

    public void increasePower(int value) {
        power += value;
    }

    public void addPlayer(Player player) {
        squad.addMember(player);
        power += player.getSkill();
    }

    public Set<Player> getPlayers() {
        return squad.getMembers();
    }

    public int getPower() {
        return power;
    }

    public void scoreGoal(Player player) {
        goals.addStat(player);
    }

    public int getGoals(Player player) {
        return goals.getStat(player);
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
