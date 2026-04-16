package com.football.model.competition;

public class Season extends Competition{
    private int year;
    public Season(String name, int year) {
        super(name);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Season{" +
                "year=" + year +
                ", name='" + name + '\'' +
                '}';
    }
}
