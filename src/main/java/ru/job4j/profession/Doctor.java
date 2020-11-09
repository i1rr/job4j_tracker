package ru.job4j.profession;

public class Doctor extends Profession {

    int bigSalary;
    boolean badWriting;

    public Doctor() {
        super();
    }

    public Doctor(String name) {
        super(name);
    }

    public Doctor(String name, String lastName) {
        super(name, lastName);
    }

    public Doctor(String name, String lastName, String education) {
        super(name, lastName, education);
    }

    public Doctor(String name, String lastName, String education, String birthday) {
        super(name, lastName, education, birthday);
    }

    public void heal() {
    }

    public void kill() {
    }

    public Diagnosis set(Patient patient) {
        Diagnosis diag = new Diagnosis();
        return diag;
    }
}
