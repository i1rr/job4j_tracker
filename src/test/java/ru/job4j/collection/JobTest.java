package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenAcsByName() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Chill", 3),
                new Job("Sleep", 2)
                );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenAcsByPriority() {
        Comparator<Job> cmpName = new JobAscByPriority();
        int rsl = cmpName.compare(
                new Job("Sleep", 3),
                new Job("Chill", 23)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Sleep", 3),
                new Job("Awake", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescByPriority() {
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(
                new Job("Sleep", 33),
                new Job("Chill", 23)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescByPriorityAndAscByName() {
        Comparator<Job> cmpName = new JobDescByPriority().thenComparing(new JobAscByName());
        int rsl = cmpName.compare(
                new Job("Chill", 33),
                new Job("Sleep", 33)
        );
        assertThat(rsl, lessThan(0));
    }

}