package org.example;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Thread weatherThread = new Thread(weatherStation);

        TempDisplay display1 = new TempDisplay("Display 1");
        TempDisplay display2 = new TempDisplay("Display 2");
        TempDisplay display3 = new TempDisplay("Display 3");

        weatherStation.addObserver(display1);
        weatherStation.addObserver(display2);
        weatherStation.addObserver(display3);

        weatherThread.start();

        try {
            Thread.sleep(15000);
            System.out.println("Removing Display 2...");
            weatherStation.removeObserver(display2);

            Thread.sleep(15000);

            weatherStation.stopStation();
            weatherThread.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}