package org.example;

public class Computer {
    private String cpu;
    private int ram;
    private String hdd;
    private String graphicCard;
    private String os;


    public String getCpu() {
        return cpu;
    }
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public void setOs(String os) {
        this.os = os;
    }
    @Override
    public String toString() {
        return "Computer Configuration:\n" +
                "Processor: " + cpu + "\n" +
                "RAM: " + ram + " GB\n" +
                "Hard Drive: " + hdd + "\n" +
                "Graphics Card: " + graphicCard + "\n" +
                "Operating System: " + os + "\n";
    }
}
