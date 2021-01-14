package ru.job4j.tracker;

public class ActionFindAll implements UserAction {

    @Override
    public String name() {
        return ">>> Showing all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] ehh = tracker.findAll();
        if (ehh.length > 0) {
            System.out.println(System.lineSeparator());
            for (Item eh : ehh) {
                System.out.println(eh);
            }
            System.out.println(System.lineSeparator());
        }
        return true;
    }
}
