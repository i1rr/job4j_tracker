package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                System.out.println(System.lineSeparator()
                        + "No such menu exists, please try again."
                        + System.lineSeparator());
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        int index = 0;
        for (UserAction action : actions) {
            out.println(index + ". " + action.name());
            index++;
        }
    }

    public static void main(String[] args) {
        Output output = new OutputConsole();
        Input input = new InputValidate(output, new InputConsole());
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ActionCreate(output));
        actions.add(new ActionFindAll(output));
        actions.add(new ActionEdit(output));
        actions.add(new ActionDelete(output));
        actions.add(new ActionFindByID(output));
        actions.add(new ActionFindByName(output));
        actions.add(new ActionExit(output));

        new StartUI(output).init(input, tracker, actions);
    }
}