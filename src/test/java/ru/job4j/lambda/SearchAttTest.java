package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SearchAttTest {
    @Test
    public void whenFilterSize() {
        List<Attachment> list = List.of(
                new Attachment("fix", 110),
                new Attachment("bug", 75),
                new Attachment("bug", 90)
        );
        List<Attachment> expected = List.of(new Attachment("fix", 110));
        Predicate<Attachment> pred = a -> a.getSize() > 100;
        List<Attachment> rsl = SearchAtt.filter(list, pred);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenFilterName() {
        List<Attachment> list = List.of(
                new Attachment("fix", 110),
                new Attachment("bug", 75),
                new Attachment("bug", 90)
        );
        List<Attachment> expected = List.of(
                new Attachment("bug", 75),
                new Attachment("bug", 90)
        );
        Predicate<Attachment> pred = a -> a.getName().contains("bug");
        List<Attachment> rsl = SearchAtt.filter(list, pred);
        assertThat(rsl, is(expected));
    }
}
