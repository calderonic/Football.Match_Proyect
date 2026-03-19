package model.person;

import java.util.Objects;

public class Manager extends Person{
    private int experience;

    public Manager(String name, int experience) {
        super(name);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager manager)) return false;
        return experience == manager.experience;
    }

    @Override
    public int hashCode() {
        return Objects.hash(experience);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "experience=" + experience +
                ", name='" + name + '\'' +
                '}';
    }
}
