package org.example;

public class ExpertState extends State {
    private static final int EXPERIENCE_TO_LEVEL_UP = 220;

    public ExpertState(Character character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println(getCharacter().getName() + " is training as an expert.");
        getCharacter().addExperience(30);
        System.out.println("Gained 30 experience points.");
        checkLevelUp();
    }

    @Override
    public void meditate() {
        System.out.println(getCharacter().getName() + " is meditating deeply.");
        getCharacter().addHealth(25);
        System.out.println("Gained 25 health points.");
        checkLevelUp();
    }

    @Override
    public void fight() {
        if (getCharacter().getHealth() < 30) {
            System.out.println("Not enough health to fight!");
            return;
        }

        System.out.println(getCharacter().getName() + " is fighting!");
        getCharacter().addHealth(-20);
        getCharacter().addExperience(40);
        System.out.println("Lost 20 health points but gained 40 experience points.");
        checkLevelUp();
    }

    @Override
    public String getStateName() {
        return "Expert";
    }

    @Override
    public void checkLevelUp() {
        if (getCharacter().getExperience() >= EXPERIENCE_TO_LEVEL_UP) {
            System.out.println(getCharacter().getName() + " has advanced to Master level!");
            getCharacter().setState(new MasterState(getCharacter()));
        }
    }
}
