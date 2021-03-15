package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FirstStreamTest {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i = -44; i < 44; i = i + 4) {
            nums.add(i);
        }
        List<Integer> stream = nums.stream().filter(x -> x > 0).collect(Collectors.toList());
        stream.forEach(System.out::println);
    }
}
