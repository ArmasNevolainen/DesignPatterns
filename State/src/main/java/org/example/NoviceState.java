package org.example;

public class NoviceState extends State{
    private static final int EXPERIENCE_TO_LEVEL_UP = 30;

    public NoviceState(Character character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println(getCharacter().getName() + " is training as a novice.");
        getCharacter().addExperience(10);
        System.out.println("Gained 10 experience points.");
        checkLevelUp();
    }

    @Override
    public void meditate() {
        System.out.println("Novices don't know how to meditate yet.");
    }

    @Override
    public void fight() {
        System.out.println("Novices don't know how to fight yet.");
    }

    @Override
    public String getStateName() {
        return "Novice";
    }

    @Override
    public void checkLevelUp() {
        if (getCharacter().getExperience() >= EXPERIENCE_TO_LEVEL_UP) {
            System.out.println(getCharacter().getName() + " has advanced to Intermediate level!");
            getCharacter().setState(new IntermediateState(getCharacter()));
        }
    }

}
