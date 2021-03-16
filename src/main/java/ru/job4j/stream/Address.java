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

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return unit + "/" + building + " "
                + street + ". " + city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return building == address.building
                && unit == address.unit
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, building, unit);
    }
}
