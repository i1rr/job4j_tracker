package ru.job4j.tracker;

public class ActionExit implements UserAction {

    private final Output out;

    public ActionExit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return ">>> Exit Program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("Game over");
        return false;
    }
}
