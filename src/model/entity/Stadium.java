package model.entity;

public class Stadium extends Entity{
    private int capacity;

    public Stadium(String name, int capacity) {
        super(name);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Stadium{" +
                "capacity=" + capacity +
                ", name='" + name + '\'' +
                '}';
    }
}
