package ru.job4j.oop;

public class VehicleUsage {
    public static void main(String[] args) {
        Vehicle airCraft = new AirCraft();
        Vehicle bus = new Bus();
        Vehicle train = new Train();

        Vehicle[] vehicles = new Vehicle[] {airCraft, bus, train};

        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
