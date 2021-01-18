package ru.job4j.tracker;

public class ActionCreate implements UserAction {

    @Override
    public String name() {
        return ">>> Create a new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        Item check = tracker.add(item);
        if (check != null) {
            System.out.println(System.lineSeparator() + "Record updated." + System.lineSeparator());
        } else {
            System.out.println(System.lineSeparator()
                    + "Error. Data base is full, please contact IT department."
                    + System.lineSeparator());
        }
        return true;
    }
}