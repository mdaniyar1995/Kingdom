package Entity;

public class Character implements Fighter {
    private String name;
    private int health;
    private int agility;
    private int strength;
    private int experience;
    private int gold;


    public Character(String name, int health, int agility, int strength, int experience, int gold) {
        this.name = name;
        this.health = health;
        this.agility = agility;
        this.strength = strength;
        this.experience = experience;
        this.gold = gold;
    }

    @Override
    public int attack() {
        if (agility * 3 > getRandomValue()) return strength;
        else return 0;

    }

    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return String.format("%s, уровень здоровья - %s", name, health);
    }
}


