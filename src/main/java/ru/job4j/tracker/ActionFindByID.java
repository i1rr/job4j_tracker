package ru.job4j.tracker;

public class ActionFindByID implements UserAction {

    @Override
    public String name() {
        return  ">>> Find an item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter ID: "));
        Item check = tracker.findById(id);
        if (check == null) {
            System.out.println(System.lineSeparator() + "ERROR!" + System.lineSeparator()
                    + "ID \"" + id + "\" doesn't exist." + System.lineSeparator());
        } else {
            System.out.println(System.lineSeparator() + check + System.lineSeparator());
        }
        return true;
    }
}