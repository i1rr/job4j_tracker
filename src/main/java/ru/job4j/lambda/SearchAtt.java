package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> pred) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (pred.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}