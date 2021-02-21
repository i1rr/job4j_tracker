package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftStr = left.split("\\. ");
        String[] rightStr = right.split("\\. ");
        int leftN = Integer.parseInt(leftStr[0]);
        int rightN = Integer.parseInt(rightStr[0]);
    return Integer.compare(leftN, rightN);
    }
}
