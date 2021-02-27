package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> mapa = new HashMap<>();
        if (left.length() != right.length()) {
            return false;
        }
        for (int i = 0; i < left.length(); i++) {
            char currentKey = left.charAt(i);
            if (mapa.containsKey(currentKey)) {
                mapa.put(currentKey, mapa.get(currentKey) + 1);
            } else {
                mapa.put(currentKey, 1);
            }
        }

        for (int i = 0; i < right.length(); i++) {
            char currentChar = right.charAt(i);
            if (mapa.containsKey(currentChar)) {
                if (mapa.get(currentChar) > 1) {
                    mapa.put(currentChar, mapa.get(currentChar) - 1);
                } else {
                    mapa.remove(currentChar);
                }
            } else {
                return false; //if current char does not exist
            }
        }
        return mapa.isEmpty();
    }
}