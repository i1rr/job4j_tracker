package ru.job4j.tracker;

public class ActionFindAll implements UserAction {

    @Override
    public String name() {
        return ">>> Showing all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
            tracker.findAll();
        return true;
    }
}
