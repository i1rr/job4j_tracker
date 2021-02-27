package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> or = new HashSet<>(Arrays.asList(origin.split(" |,|;|:|!|[.]")));
        Set<String> li = new HashSet<>(Arrays.asList(line.split(" |,|;|:|!|[.]")));
        for (String aWord : li) {
            if (!or.contains(aWord)) {
                return false;
            }
        }
        return true;
    }
}