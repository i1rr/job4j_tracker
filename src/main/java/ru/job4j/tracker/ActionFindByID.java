package ru.job4j.tracker;

public class ActionFindByID implements UserAction {

    @Override
    public String name() {
        return  ">>> Find an item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter ID: "));
        tracker.findById(id);
        return true;
    }
}