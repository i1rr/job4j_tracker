package ru.job4j.stream;

import java.util.Objects;

public class Address {
    private String city, street;
    private int building, unit;

    public Address(String city, String street, int building, int unit) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return unit + "/" + building + " "
                + street + ". " + city;
    }
}
