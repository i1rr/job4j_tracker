package ru.job4j.profession;

public class Engineer extends Profession {

    private int averageSalary;
    private boolean alcoholic;

    public Engineer() {
        super();
    }

    public Engineer(String name) {
        super(name);
    }

    public Engineer(String name, String lastName) {
        super(name, lastName);
    }

    public Engineer(String name, String lastName, String education) {
        super(name, lastName, education);
    }

    public Engineer(String name, String lastName, String education, String birthday) {
        super(name, lastName, education, birthday);
    }

    public void develop() {
    }

    public void wasteLife() {
    }
}
