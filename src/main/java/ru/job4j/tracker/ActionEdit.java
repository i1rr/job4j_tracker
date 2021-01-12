package ru.job4j.tracker;

public class ActionEdit implements UserAction {
    @Override
    public String name() {
        return ">>> Edit an item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter ID to replace: "));
        System.out.println();
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Record updated.");
        } else {
            System.out.println("ERROR!" + System.lineSeparator()
                    + "ID \"" + id + "\" doesn't exist.");
        }
        return true;
    }
}