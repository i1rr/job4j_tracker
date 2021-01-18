package ru.job4j.tracker;

public class ActionFindByID implements UserAction {

    private final Output out;

    public ActionFindByID(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return  ">>> Find an item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter ID: "));
        Item check = tracker.findById(id);
        if (check == null) {
            out.println(System.lineSeparator() + "ERROR!" + System.lineSeparator()
                    + "ID \"" + id + "\" doesn't exist." + System.lineSeparator());
        } else {
            out.println(System.lineSeparator() + check + System.lineSeparator());
        }
        return true;
    }
}