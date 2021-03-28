package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(in -> in.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(-1);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(ppl -> new Tuple(ppl.getName(), averageScore(Stream.of(ppl))))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(ppl -> ppl.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(i -> new Tuple(i.getKey(), i.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(ppl -> new Tuple(ppl.getName(), ppl.getSubjects()
                .stream().mapToDouble(Subject::getScore).sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("Error", -1));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(ppl -> ppl.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(i -> new Tuple(i.getKey(), i.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("Error", -1));
    }
}