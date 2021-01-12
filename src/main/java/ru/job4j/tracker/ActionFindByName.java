package ru.job4j.tracker;

public class ActionFindByName implements UserAction {

    @Override
    public String name() {
        return ">>> Find an item by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] ehh = tracker.findByName(name);
        if (ehh.length == 0) {
           System.out.println("Such name doesn't exist.");
        }
        return true;
    }
}