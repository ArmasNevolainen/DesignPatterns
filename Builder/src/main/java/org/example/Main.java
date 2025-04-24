package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Build Office Computer
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector director1 = new ComputerDirector(officeBuilder);
        director1.constructComputer();
        Computer officeComputer = officeBuilder.getComputer();
        System.out.println("Office Computer:\n" + officeComputer);

        // Build Gaming Computer
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director2 = new ComputerDirector(gamingBuilder);
        director2.constructComputer();
        Computer gamingComputer = gamingBuilder.getComputer();
        System.out.println("Gaming Computer:\n" + gamingComputer);
    }
}