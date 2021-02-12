package ru.job4j.tracker;

import java.util.ArrayList;

public class ActionFindByName implements UserAction {

    private final Output out;

    public ActionFindByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return ">>> Find an item by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        ArrayList<Item> ehh = tracker.findByName(name);
        if (ehh.size() == 0) {
           out.println(System.lineSeparator() + "Such name doesn't exist."
                   + System.lineSeparator());
        } else {
            for (Item item : ehh) {
                out.println(item);
            }
        }
        return true;
    }
}