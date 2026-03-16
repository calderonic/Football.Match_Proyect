public class Player {
    private String name;
    private int skill;
    private int price;

    public Player(String name, int skill, int price) {
        this.name = name;
        this.skill = skill;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
