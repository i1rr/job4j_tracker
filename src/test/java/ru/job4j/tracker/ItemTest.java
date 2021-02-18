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
        Item item1 = new Item(1, "aaa");
        Item item2 = new Item(2, "bbb");
        Item item3 = new Item(3, "ccc");
        List<Item> items = Arrays.asList(item3, item2, item1);
        List<Item> items2 = Arrays.asList(item1, item2, item3);
        Collections.sort(items);
        assertThat(items, is(items2));
    }

    @Test
    public void whenSortUpByName() {
        Item item1 = new Item(1, "aaa");
        Item item2 = new Item(2, "bbb");
        Item item3 = new Item(3, "ccc");
        List<Item> items = Arrays.asList(item3, item2, item1);
        List<Item> items2 = Arrays.asList(item1, item2, item3);
        Collections.sort(items);
        assertThat(items, is(items2));
        Collections.sort(items, new SortByNameItem());
        assertThat(items, is(items2));
    }

    @Test
    public void whenSortDown() {
        Item item1 = new Item(1, "aaa");
        Item item2 = new Item(2, "bbb");
        Item item3 = new Item(3, "ccc");
        List<Item> items = Arrays.asList(item1, item2, item3);
        List<Item> items2 = Arrays.asList(item3, item2, item1);
        Collections.sort(items, Collections.reverseOrder());
        assertThat(items, is(items2));
    }

    @Test
    public void whenSortDownByName() {
        Item item1 = new Item(1, "aaa");
        Item item2 = new Item(2, "bbb");
        Item item3 = new Item(3, "ccc");
        List<Item> items = Arrays.asList(item3, item1, item2);
        List<Item> items2 = Arrays.asList(item3, item2, item1);
        Collections.sort(items, Collections.reverseOrder(new SortByNameItem()));
        assertThat(items, is(items2));
    }
}