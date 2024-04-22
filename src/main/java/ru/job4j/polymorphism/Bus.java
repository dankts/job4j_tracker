package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println("Едет");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Кол-во пассажиров " + passengers);
    }

    @Override
    public double refuel(double refuel) {
        return refuel * 50.0;
    }
}
