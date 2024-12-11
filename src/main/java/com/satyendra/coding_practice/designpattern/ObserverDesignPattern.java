package com.satyendra.coding_practice.designpattern;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(double temperature);
}

class PhoneDevice implements Observer {
    private double temperature;
    @Override
    public void update(double temperature) {
        this.temperature = temperature;
    }

    private void display() {
        System.out.println("Phone device temperature : " + temperature);
    }
}

class TVDevice implements Observer {
    private double temperature;
    @Override
    public void update(double temperature) {
        this.temperature = temperature;
    }

    private void display() {
        System.out.println("TV device temperature : " + temperature);
    }
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);

    void notifyObservers(double temperature);
}

class WeatherStation implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private double temperature;
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers(temperature);
    }
    @Override
    public void notifyObservers(double temperature) {
        for(Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
public class ObserverDesignPattern {

    public static void main(String[] args) {
        Observer phoneObserver = new PhoneDevice();
        Observer tvObserver = new TVDevice();

        WeatherStation station = new WeatherStation();
        station.addObserver(phoneObserver);
        station.addObserver(tvObserver);

        station.setTemperature(102.2);
    }
}
