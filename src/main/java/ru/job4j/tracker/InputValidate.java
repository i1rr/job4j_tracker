package ru.job4j.tracker;

public class InputValidate extends InputConsole {

    @Override
    public int askInt(String question) {
        boolean valid = false;
        int value = -1;
        while (!valid) {
            try {
                value = super.askInt(question);
                valid = true;
            } catch (NumberFormatException nFe) {
                System.out.println(System.lineSeparator()
                        + "Please enter valid data"
                + System.lineSeparator());
            }
        }
        return value;
    }
}
