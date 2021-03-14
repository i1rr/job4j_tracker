package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class FunctionInRange {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (double i = start; i < end; i++) {
            rsl.add(func.apply(i));
        }
        return rsl;
    }
}
