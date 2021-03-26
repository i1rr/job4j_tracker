package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private final List<Integer> buffer;

    public EasyStream(List<Integer> buffer) {
        this.buffer = buffer;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        var list = new ArrayList<Integer>();
        for (Integer rr : buffer) {
            list.add(fun.apply(rr));
        }
        return EasyStream.of(list);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        var list = new ArrayList<Integer>();
        for (Integer rr : buffer) {
            if (fun.test(rr)) {
                list.add(rr);
            }
        }
        return EasyStream.of(list);
    }

    public List<Integer> collect() {
        return buffer;
    }
}