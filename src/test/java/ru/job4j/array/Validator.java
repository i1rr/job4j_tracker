package ru.job4j.array;

public class Validator {
    public static boolean checkArray(int[] data, int value) {
        int duplicateCount = 0;
        for (int rr : data) {
            if (value == rr) {
                duplicateCount++;
            }
        }
        return (data.length / 2) >= duplicateCount;
    }
}