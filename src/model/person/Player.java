package model.person;

import java.util.Objects;

public class Player extends Person {
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
}
