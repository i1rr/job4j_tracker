package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("obama@whitehouse.com", "Barak Sergeevich Obama");
        map.put("vova@kreml.ru", "Vladimir Vladimirovich Putin");

        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
