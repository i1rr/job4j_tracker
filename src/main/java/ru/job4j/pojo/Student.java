package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String name;
    private String lastName;
    private String patronicName;
    private String group;
    private Date commencement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronicName() {
        return patronicName;
    }

    public void setPatronicName(String patronicName) {
        this.patronicName = patronicName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getCommencement() {
        return commencement;
    }

    public void setCommencement(Date commencement) {
        this.commencement = commencement;
    }

    public void getDetails () {
        System.out.println("Имя: " + this.getName());
        System.out.println("Фамилия: " + this.getLastName());
        System.out.println("Отчество: " + this.getPatronicName());
        System.out.println("Группа: " + this.getGroup());
        System.out.println("Дата поступления: " + this.getCommencement());
    }
}
