package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Runnable {
    private int temperature;
    private Random random = new Random();
    private final List<Observer> observers = new ArrayList<>();
    private volatile boolean running = true;
    private static final int MIN_TEMP = -40;
    private static final int MAX_TEMP = 40;

    public WeatherStation() {
        this.temperature = random.nextInt(81)-40;

    }
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void stopStation() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(random.nextInt(4000) + 1000);

                int change = random.nextBoolean() ? 1 : -1;
                int newTemp = temperature + change;

                if (newTemp >= MIN_TEMP && newTemp <= MAX_TEMP) {
                    temperature = newTemp;
                    notifyObservers();
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

}
