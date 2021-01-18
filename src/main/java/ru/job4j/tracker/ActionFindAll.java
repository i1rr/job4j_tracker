package ru.job4j.tracker;

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
        Item[] ehh = tracker.findAll();
        if (ehh.length > 0) {
            out.println(System.lineSeparator());
            for (Item eh : ehh) {
                out.println(eh);
            }
            out.println(System.lineSeparator());
        }
        return true;
    }
}
