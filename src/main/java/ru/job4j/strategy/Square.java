package ru.job4j.strategy;

public class Square implements Shape {

    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "___" + ln
                + "| |" + ln
                + "---" + ln
                + "Mama ama Square";
    }

    public static void main(String[] args) {
        System.out.println(new Square().draw());
    }
}
