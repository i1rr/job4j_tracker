package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int stringLength = Math.min(left.length(), right.length());
        System.out.println(stringLength);
        for(int index = 0; index < stringLength; index++) {
            rsl += Integer.compare(left.charAt(index), right.charAt(index));
        }
        if (rsl == 0) {
            rsl = Integer.compare(left.length(), right.length());
        }
        return rsl;
    }
}
