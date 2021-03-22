package ru.job4j.array;

public class ArrayInSquareArray {
    public static int[][] convertArray(int[] array) {
        int arrSize = (int) Math.ceil(Math.sqrt(array.length));
        int[][] rsl = new int[arrSize][arrSize];
        int out = 0;
        int in = 0;
        for (int gg : array) {
            rsl[out][in++] = gg;
            System.out.println(gg);
            if (in > arrSize - 1) {
                out++;
                in = 0;
            }
        }
        return rsl;
    }
}