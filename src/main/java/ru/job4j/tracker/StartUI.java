package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item vasjaOne = new Item(1, "Vasilij");

        tracker.add(vasjaOne);

        System.out.println(tracker.findById(1));

        /**
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormatter = item.getCreated().format(formatter);
        System.out.println(currentDateTimeFormatter);

        Item toStringExc = new Item(1, "xpeH");
        System.out.println(toStringExc);
       */
    }
}
