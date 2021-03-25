package ru.job4j.array;

public class EvenSumElements {
    public static boolean checkArray(int[] data) {
        int sum = 0;
        for (int rr : data) {
            sum += rr;
        }
        return isEven(sum);
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}