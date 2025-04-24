package org.example;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setCpu("AMD Ryzen 9");
    }

    @Override
    public void buildRam() {
        computer.setRam(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHdd("2 TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicCard("NVIDIA GeForce RTX 5090");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOs("Windows 11 Ultimate");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
