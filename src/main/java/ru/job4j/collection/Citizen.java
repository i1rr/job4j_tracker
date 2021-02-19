package ru.job4j.collection;

import java.util.Objects;

public class Citizen {
    private String passport, tovarisch;

    public Citizen(String passport, String tovarisch) {
        this.passport = passport;
        this.tovarisch = tovarisch;
    }

    public String getPassport() {
        return passport;
    }

    public String getUsername() {
        return tovarisch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Citizen citizen = (Citizen) o;
        return Objects.equals(passport, citizen.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
