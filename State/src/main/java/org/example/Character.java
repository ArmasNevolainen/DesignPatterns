package org.example;

public class Character {
    private String name;
    private State level;
    private int experience;
    private int health;


    public Character(String name) {
        this.name = name;
        this.level = new NoviceState(this);
        this.experience = 0;
        this.health = 30;
    }

    public void train() {
        level.train();
    }

    public void meditate() {
        level.meditate();
    }

    public void fight() {
        level.fight();
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public void addExperience(int points) {
        this.experience += points;
    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int points) {
        this.health += points;
        if (this.health > 100) {
            this.health = 100;
        }
    }

    public void setState(State newState) {
        this.level = newState;
    }

    public State getState() {
        return level;
    }

    public String getStatus() {
        return "Character: " + name +
                "\nState: " + level.getStateName() +
                "\nExperience Points: " + experience +
                "\nHealth Points: " + health;
    }
}
