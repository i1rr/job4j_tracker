package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SearchAttTest {

    @Test
    public void whenFilterByName() {
        List<Attachment> test = Arrays.asList(
                new Attachment("gaz", 202),
                new Attachment("tormoz", 99),
                new Attachment("poluGaz", 101),
                new Attachment("bug", 101)
        );

        List<Attachment> rsl = SearchAtt.filterName(test);
        assertThat(rsl.toString(), is("[" + new Attachment("bug", 101) + "]"));
    }

    @Test
    public void whenFilterBySize() {
        List<Attachment> test = Arrays.asList(
                new Attachment("gaz", 202),
                new Attachment("tormoz", 99),
                new Attachment("poluGaz", 10),
                new Attachment("bug", 1)
        );
        List<Attachment> rsl = SearchAtt.filterSize(test);
        assertThat(rsl.toString(), is("[" + new Attachment("gaz", 202) + "]"));
    }
}