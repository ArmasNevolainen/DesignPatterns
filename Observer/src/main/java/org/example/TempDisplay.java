package org.example;

public class TempDisplay  implements Observer {
    private String name;

    public TempDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " shows a temperature of " + temperature + " degrees Celsius.");
    }

}
