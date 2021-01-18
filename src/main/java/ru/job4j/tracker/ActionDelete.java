package ru.job4j.tracker;

public class ActionDelete implements UserAction {

    private final Output out;

    public ActionDelete(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return ">>> Delete an item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter item's ID: "));
        if (tracker.delete(id)) {
            out.println(System.lineSeparator() + "ID " + id + " deleted."
                    + System.lineSeparator());
        } else {
            out.println(System.lineSeparator() + "ERROR!" + System.lineSeparator()
                    + "ID \"" + id + "\" doesn't exist." + System.lineSeparator());
        }
        return true;
    }
}
