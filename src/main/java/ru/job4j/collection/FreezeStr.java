package ru.job4j.collection;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        HashMap<Integer, Character> leftHm = new HashMap<>();
        HashMap<Integer, Character> rightHm = new HashMap<>();
        //spread left and right Strings to hashMaps only if length is the same
        //otherwise they can't be the same
        if (left.length() == right.length()) {
            for (int i = 0; i < left.length(); i++) {
                leftHm.put(i, left.charAt(i));
                rightHm.put(i, right.charAt(i));
            }
        } else {
            return false;
            }

        //if a value of right hashmap found in left hashmap,
        // then that value removes from left hashmap. And break.
        for (Integer key : rightHm.keySet()) {
            char value = rightHm.get(key);
            for (Integer keyL : leftHm.keySet()) {
                char valueL = leftHm.get(keyL);
                if (value == valueL) {
                   leftHm.remove(keyL);
                   break;
                }
            }
        }
        //if left hashMap is empty then it means we have 100% match of characters
        return leftHm.isEmpty();
    }
}