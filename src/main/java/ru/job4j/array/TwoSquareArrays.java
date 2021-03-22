package ru.job4j.array;

public class TwoSquareArrays {
    public static int[] twoLvlToOneLvlArray(int[][] array) {
        int length = 0;
        for (int[] first : array) {
            length += first.length;
        }

        int[] rsl = new int[length];
        int iter = 0;
        for (int[] gg : array) {
            for (int zz : gg) {
                rsl[iter++] = zz;
            }
        }
        return rsl;
    }

    public static int[] collectArray(int[][] left, int[][] right) {
        int[] leftOne = twoLvlToOneLvlArray(left);
        int[] rightOne = twoLvlToOneLvlArray(right);
        int shortestArray = Math.min(leftOne.length, rightOne.length);
        int[] rsl = leftOne.length > rightOne.length
                ? new int[leftOne.length] : new int[rightOne.length];
        for (int i = 0; i < shortestArray; i++) {
            rsl[i] = Math.max(leftOne[i], rightOne[i]);
        }
        int arrayLeftover = Math.abs(leftOne.length - rightOne.length);

        if (leftOne.length > rightOne.length) {
            for (int i = leftOne.length - arrayLeftover; i < leftOne.length; i++) {
                rsl[i] = leftOne[i];
                System.out.println(rsl[i]);
            }
        } else if (leftOne.length < rightOne.length) {
            for (int i = rightOne.length - arrayLeftover; i < rightOne.length; i++) {
                rsl[i] = rightOne[i];
                System.out.println(rsl[i]);
            }
        }
        return rsl;
    }
}