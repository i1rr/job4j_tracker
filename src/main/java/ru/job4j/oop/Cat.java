package ru.job4j.oop;

public class Cat {

    public String sound() {
        String voice = "Meow";
        return voice;
    }

    private String food;
    private String name;

    public void show() {
        System.out.println(this.name + "'s favourite food is " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("Kotleta.");
        gav.show();

        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("Fish.");
        black.show();
    }
}
