package ru.job4j.collection;

import java.util.Objects;

public class Account {
    private String passport, username, deposit;

    public Account(String passport, String username, String deposit) {
        this.passport = passport;
        this.username = username;
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(passport, account.passport);
    }
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return "Account{" +
                "passport ='" + username + '\'' +
                ", deposit'" + deposit + '\'' +
                '}';
    }
}