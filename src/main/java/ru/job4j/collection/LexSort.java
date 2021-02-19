package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int leftT = retrieveNumsInRow(left);
        int rightT = retrieveNumsInRow(right);
            return Integer.compare(leftT, rightT);
    }

    public int retrieveNumsInRow(String string) {
        char[] lalala = string.toCharArray();
        String number = "";
        for (char ch : lalala) {
            if (Character.isDigit(ch)) {
                number += Character.toString(ch);
            } else {
                break;
            }
        }
        return Integer.parseInt(number);
    }
}
