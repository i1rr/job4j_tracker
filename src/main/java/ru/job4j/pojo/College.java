package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student vasjaVasin = new Student();
        vasjaVasin.setName("Vasilij");
        vasjaVasin.setLastName("Vasin");
        vasjaVasin.setPatronicName("Vasilijevitch");
        vasjaVasin.setGroup("Computer Science");
        vasjaVasin.setCommencement(new Date());

        vasjaVasin.getDetails();

        //or
        /**
        System.out.println("Имя: " + vasjaVasin.getName());
        System.out.println("Фамилия: " + vasjaVasin.getLastName());
        System.out.println("Отчество: " + vasjaVasin.getName());
        System.out.println("Группа: " + vasjaVasin.getGroup());
        System.out.println("Дата поступления: " + vasjaVasin.getCommencement());
        */
    }
}
