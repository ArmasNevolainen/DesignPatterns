package org.example;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setCpu("Intel Core i5");
    }

    @Override
    public void buildRam() {
        computer.setRam(8);
    }

    @Override
    public void buildHardDrive() {
        computer.setHdd("512 GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicCard("Integrated Graphics");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOs("Windows 11 Pro");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }


}
