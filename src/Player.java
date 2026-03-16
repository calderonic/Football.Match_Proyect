public class Player {
    private String name;
    private int skillLevel;
    private int price;

    public Player(String name, int skillLevel, int price) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
