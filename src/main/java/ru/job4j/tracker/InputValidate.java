package ru.job4j.tracker;

public class InputValidate implements Input {

    private final Output out;
    private final Input in;

    public InputValidate(Output out, Input in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nFe) {
                out.println(System.lineSeparator()
                        + "Please enter valid data"
                + System.lineSeparator());
            }
        } while (invalid);
        return value;
    }
}
