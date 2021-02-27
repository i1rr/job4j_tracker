package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        int maxCompareLength = Math.min(o1.length(), o2.length());
        for (int i = 0; i < maxCompareLength; i++) {
            rsl = Integer.compare(o1.charAt(i), o2.charAt(i));
                    if (rsl != 0) {
                        break;
                    }
        }
        return rsl == 0 ? rsl - 1 : rsl;
    }
}