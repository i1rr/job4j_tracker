package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {

        System.out.println("Fairytale KOLOBOK" + System.lineSeparator());

        Ball kolobok = new Ball();
        Hare zayac = new Hare();
        Wolf volk = new Wolf();
        Fox lisa = new Fox();

        zayac.tryEat(kolobok);
        kolobok.evade(zayac);

        volk.tryEat(kolobok);
        kolobok.evade(volk);

        lisa.tryEat(kolobok);
        kolobok.evade(lisa);
    }
}

