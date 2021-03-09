package ru.job4j.lambda;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> pred = a -> a.getSize() > 100;
        return uniFilter(list, pred);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> pred = a -> a.getName().contains("bug");
       return uniFilter(list, pred);
    }

    private static List<Attachment> uniFilter(List<Attachment> list, Predicate<Attachment> pred) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (pred.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Attachment> test = Arrays.asList(
                new Attachment("gaz", 202),
                new Attachment("tormoz", 99),
                new Attachment("poluGaz", 101),
                new Attachment("bug", 101)
        );

        filterSize(test);
        filterName(test);
        for (Attachment ts : test) {
            System.out.println(ts);
        }
    }
}