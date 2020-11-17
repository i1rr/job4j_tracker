package ru.job4j.oop;

public class AirCraft implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " is fucks the sky");
    }
}
