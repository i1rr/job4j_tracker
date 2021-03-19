package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StudentTest {
    @Test
    public void whenConvertListToMap() {
        List<Student> studs = new ArrayList<>();
                Student fedja = new Student(99, "Fedenka");
                Student masha = new Student(100, "Mashenka");
                Student vladimir = new Student(14, "Vovochka");
                Student ivan = new Student(+100500, "Ioann");
                studs.add(fedja);
                studs.add(masha);
                studs.add(vladimir);
                studs.add(ivan);
                studs.add(vladimir);
                studs.add(masha);
                studs.add(fedja);
                Map<String, Student> studentMap = Map.of(
                        fedja.getSurname(), fedja,
                masha.getSurname(), masha,
                vladimir.getSurname(), vladimir,
                ivan.getSurname(), ivan
                );

                assertThat(Student.listToMap(studs), is(studentMap));
    }
}