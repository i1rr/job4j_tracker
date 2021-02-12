package ru.job4j.tracker;

import java.util.ArrayList;

public class ActionFindAll implements UserAction {

    private final Output out;

    public ActionFindAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return ">>> Showing all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        ArrayList<Item> ehh = tracker.findAll();
            out.println(System.lineSeparator());
            for (Item eh : ehh) {
                out.println(eh);
            }
            out.println(System.lineSeparator());
        return true;
    }
}
