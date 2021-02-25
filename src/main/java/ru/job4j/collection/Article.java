package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        HashSet<String> words = new HashSet<>(Arrays.asList(origin.split(" |,|;|:|!|[.]")));
        int trick = words.size();
        words.addAll(Arrays.asList(line.split(" |,|;|:|!|[.]")));
        return trick == words.size();
    }
}