package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemTest {

    @Test
    public void whenSortUp() {
        List<Item> items = Arrays.asList(
                new Item(2, "bbb"),
                new Item(1, "aaa"),
                new Item(6, "ccc")
        );

        List<Item> items2 = Arrays.asList(
                new Item(1, "aaa"),
                new Item(2, "bbb"),
                new Item(6, "ccc")
        );
        Collections.sort(items);
        assertThat(items, is(items2));
    }

    @Test
    public void whenSortUpByName() {
        List<Item> items = Arrays.asList(
                new Item(2, "bbb"),
                new Item(1, "ccc"),
                new Item(6, "aaa")
        );

        List<Item> items2 = Arrays.asList(
                new Item(6, "aaa"),
                new Item(2, "bbb"),
                new Item(1, "ccc")
        );
        Collections.sort(items, new SortByNameItem());
        assertThat(items, is(items2));
    }

    @Test
    public void whenSortDown() {
        List<Item> items = Arrays.asList(
                new Item(2, "bbb"),
                new Item(1, "aaa"),
                new Item(6, "ccc")
        );

        List<Item> items2 = Arrays.asList(
                new Item(6, "ccc"),
                new Item(2, "bbb"),
                new Item(1, "aaa")
        );
        Collections.sort(items, Collections.reverseOrder());
        assertThat(items, is(items2));
    }

    @Test
    public void whenSortDownByName() {
        List<Item> items = Arrays.asList(
                new Item(2, "bbb"),
                new Item(1, "ccc"),
                new Item(6, "aaa")
        );
        List<Item> items2 = Arrays.asList(
                new Item(1, "ccc"),
                new Item(2, "bbb"),
                new Item(6, "aaa")
        );
        Collections.sort(items, Collections.reverseOrder(new SortByNameItem()));
        assertThat(items, is(items2));
    }
}