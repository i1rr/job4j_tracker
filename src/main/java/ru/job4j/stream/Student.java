package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Student {
    private int score;

    private String surname;

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    public static Map<String, Student> listToMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                Student::getSurname,
                e -> e,
                (stud1, stud2) -> stud1
        ));
    }

    @Override
    public String toString() {
        return "Student{"
               + "score=" + score
                + ", surname='" + surname + '\''
               + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }
}