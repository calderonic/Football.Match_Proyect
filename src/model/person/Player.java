package model.person;

import interfaces.IBuyable;
import interfaces.ITrainable;

import java.util.Objects;

public class Player extends Person implements ITrainable, IBuyable {
    private int skill;
    private int price;

    public Player(String name, int skill, int price) {
        super(name);
        this.skill = skill;
        this.price = price;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void train() {
        skill += 5;
        System.out.println(getName() + " trained. New skill: " + skill);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return skill == player.skill && price == player.price;
    }

    @Override
    public String toString() {
        return "Player{" +
                "skill=" + skill +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(skill, price);
    }

    @Override
    public boolean canBeBought(int budget) {
        return budget >= price;
    }
}
