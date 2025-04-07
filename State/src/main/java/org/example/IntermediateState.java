package org.example;

public class IntermediateState extends State {
    private static final int EXPERIENCE_TO_LEVEL_UP = 100;

    public IntermediateState(Character character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println(getCharacter().getName() + " is training as an intermediate.");
        getCharacter().addExperience(20);
        System.out.println("Gained 20 experience points.");
        checkLevelUp();
    }

    @Override
    public void meditate() {
        System.out.println(getCharacter().getName() + " is meditating.");
        getCharacter().addHealth(15);
        System.out.println("Gained 15 health points.");
        checkLevelUp();
    }

    @Override
    public void fight() {
        System.out.println("Intermediates don't know how to fight yet.");
    }

    @Override
    public String getStateName() {
        return "Intermediate";
    }

    @Override
    public void checkLevelUp() {
        if (getCharacter().getExperience() >= EXPERIENCE_TO_LEVEL_UP) {
            System.out.println(getCharacter().getName() + " has advanced to Expert level!");
            getCharacter().setState(new ExpertState(getCharacter()));
        }
    }
}

