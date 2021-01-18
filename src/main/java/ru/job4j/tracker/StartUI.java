package ru.job4j.tracker;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new OutputConsole();
        Input input = new InputConsole();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ActionCreate(output),
                new ActionFindAll(output),
                new ActionEdit(output),
                new ActionDelete(output),
                new ActionFindByID(output),
                new ActionFindByName(output),
                new ActionExit(output)

        };
        new StartUI(output).init(input, tracker, actions);
    }
}