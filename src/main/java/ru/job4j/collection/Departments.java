package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();

        for (String value : deps) {
            String[] separated = value.split("/");
            String temp = "";
            if (separated.length > 1) {
                for (int i = 0; i < separated.length - 1; i++) {
                    temp = temp + "/" + separated[i];
                }

                if (temp.charAt(0) == '/') {
                    tmp.add(temp.substring(1));
                } else {
                    tmp.add(temp);
                }
            }
            tmp.add(value);
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
    }

    public static void sortDesc(List<String> orgs) {
    }
}