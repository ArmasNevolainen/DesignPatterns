package org.example;

public class MasterState extends State {

    public MasterState(Character character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println(getCharacter().getName() + " is a master and has completed all training.");
    }

    @Override
    public void meditate() {
        System.out.println(getCharacter().getName() + " is a master and has achieved perfect meditation.");
    }

    @Override
    public void fight() {
        System.out.println(getCharacter().getName() + " is a master and has mastered all fighting techniques.");
    }

    @Override
    public String getStateName() {
        return "Master";
    }

    @Override
    public void checkLevelUp() {
        // No more level ups
    }
}
