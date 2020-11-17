package ru.job4j.oop;

public class Ball {

    public void evade(Object object) {
        System.out.println("Kolobok: Slow down, lemme sing you a song");
        System.out.println("Kolobok: I hope you got a plan, catch me if you can"
                + System.lineSeparator());
    }

    public void evade(Fox fox) {
        System.out.println("Kolobok: I hope..F#@!");
        System.out.println("RIP" + System.lineSeparator() + "THE END");
    }

    public void evade(Hare zayac) {
    }

    public void evade(Wolf volk) {
    }
}
