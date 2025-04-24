package org.example;

public interface ComputerBuilder {
    public void buildProcessor();
    public void buildRam();
    public void buildHardDrive();
    public void buildGraphicsCard();
    public void buildOperatingSystem();
    public Computer getComputer();
}
