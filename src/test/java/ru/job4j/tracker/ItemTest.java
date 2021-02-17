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
                new Item(2, "zz"),
                new Item(1, "sda"),
                new Item(6, "fds")
        );
        Collections.sort(items);
        assertThat(items.toString(), is("[Item{id=1, name='sda', created=17-02-2021}," +
                " Item{id=2, name='zz', created=17-02-2021}," +
                " Item{id=6, name='fds', created=17-02-2021}]"));
    }

    @Test
    public void whenSortUpByName() {
        List<Item> items = Arrays.asList(
                new Item(2, "bbb"),
                new Item(1, "ccc"),
                new Item(6, "aaa")
        );
        Collections.sort(items, new SortByNameItem());
        assertThat(items.toString(), is("[Item{id=6, name='aaa', created=17-02-2021}," +
                " Item{id=2, name='bbb', created=17-02-2021}," +
                " Item{id=1, name='ccc', created=17-02-2021}]"));
    }

    @Test
    public void whenSortDown() {
        List<Item> items = Arrays.asList(
                new Item(2, "zz"),
                new Item(1, "sda"),
                new Item(6, "fds")
        );
        Collections.sort(items, Collections.reverseOrder());
        assertThat(items.toString(), is("[Item{id=6, name='fds', created=17-02-2021}," +
                " Item{id=2, name='zz', created=17-02-2021}," +
                " Item{id=1, name='sda', created=17-02-2021}]"));
    }

    @Test
    public void whenSortDownByName() {
        List<Item> items = Arrays.asList(
                new Item(2, "bbb"),
                new Item(1, "ccc"),
                new Item(6, "aaa")
        );
        Collections.sort(items, Collections.reverseOrder(new SortByNameItem()));
        assertThat(items.toString(), is("[Item{id=1, name='ccc', created=17-02-2021}," +
                " Item{id=2, name='bbb', created=17-02-2021}," +
                " Item{id=6, name='aaa', created=17-02-2021}]"));
    }
}