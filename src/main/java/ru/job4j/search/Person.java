package ru.job4j.search;

public class Person {
    private String name;
    private String lastName;
    private String phone;
    private String address;

    public Person(String name, String lastName, String phone, String address) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
