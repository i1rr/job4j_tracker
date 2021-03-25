package ru.job4j.array;

public class EditorElementsArray {
    public static int[][] changeData(int[][] array, int el) {
        for (int out = 0; out < array.length; out++) {
            for (int in = 0; in < array[out].length; in++) {
                if (array[out][in] > el) {
                    array[out][in] = array[out][in] - el;
                } else {
                    array[out][in] = 0;
                }
            }
        }
        return array;
    }
}