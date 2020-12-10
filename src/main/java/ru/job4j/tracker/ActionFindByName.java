package ru.job4j.tracker;

public class ActionFindByName implements UserAction {

    @Override
    public String name() {
        return ">>> Find an item by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        tracker.findByName(name);
        return true;
    }
}