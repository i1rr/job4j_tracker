package ru.job4j.tracker;

public class InputStub implements Input {
    private String[] answers;
    private String answer;
    private int position = 0;

    public InputStub(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
