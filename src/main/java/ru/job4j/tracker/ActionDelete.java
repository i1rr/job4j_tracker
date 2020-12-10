package ru.job4j.tracker;

public class ActionDelete implements UserAction {
    @Override
    public String name() {
        return ">>> Delete an item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter item's ID: "));
        tracker.delete(id);
        return true;
    }
}
