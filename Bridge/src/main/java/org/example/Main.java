package org.example;


public class Main {
    public static void main(String[] args) {
        {
            Vehicle vehicle1 = new Car(new Produce(), new Assemble());
            vehicle1.manufacture();
            Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
            vehicle2.manufacture();
            Vehicle vehicle3 = new SportsCar(new Produce(), new Assemble(), new Paint());
            vehicle3.manufacture();
        }
    }
}