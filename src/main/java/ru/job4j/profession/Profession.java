package ru.job4j.profession;

public class Profession {
    private String name;
    private String lastName;
    private String education;
    private String birthday;

    public Profession () {
        this.name = "Unknown";
        this.lastName = "Unknown";
        this.education = "Unknown";
        this.birthday = "Unknown";
    }

    public Profession (String name) {
        this.name = name;
        this.lastName = "Unknown";
        this.education = "Unknown";
        this.birthday = "Unknown";
    }

    public Profession (String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.education = "Unknown";
        this.birthday = "Unknown";
    }

    public Profession (String name, String lastName, String education) {
        this.name = name;
        this.lastName = lastName;
        this.education = education;
        this.birthday = "Unknown";
    }

    public Profession (String name, String lastName, String education, String birthday) {
        this.name = name;
        this.lastName = lastName;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEducation() {
        return education;
    }
    public String getBirthday() {
        return birthday;
    }
}
