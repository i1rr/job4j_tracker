package ru.job4j.array;

public class Converter {
    public static int[][] convertInSquareArray(int[][] array) {
        return ArrayInSquareArray.convertArray(TwoSquareArrays.twoLvlToOneLvlArray(array));
    }
}