package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
    }

    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("\"N\" value can not be negative");
        }
        int rsl = 1;
        for (int i = 1; i <= n; i++) {
            rsl *= i;
        }
        return rsl;
    }
}
