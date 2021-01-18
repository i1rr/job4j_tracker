package ru.job4j.tracker;

public class ActionEdit implements UserAction {

    private final Output out;

    public ActionEdit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return ">>> Edit an item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter ID to replace: "));
        out.println(System.lineSeparator());
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
           out.println(System.lineSeparator() + "Record updated." + System.lineSeparator());
        } else {
            out.println(System.lineSeparator() + "ERROR!" + System.lineSeparator()
                    + "ID \"" + id + "\" doesn't exist." + System.lineSeparator());
        }
        return true;
    }
}