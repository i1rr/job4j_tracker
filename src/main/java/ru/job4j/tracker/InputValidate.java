package ru.job4j.tracker;

public class InputValidate extends InputConsole {

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nFe) {
                System.out.println(System.lineSeparator()
                        + "Please enter valid data"
                + System.lineSeparator());
            }
        } while (invalid);
        return value;
    }
}
