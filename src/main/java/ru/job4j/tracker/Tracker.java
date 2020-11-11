package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] temp = new Item[size];
        int tempCounter = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                temp[tempCounter] = items[i];
                tempCounter++;
            }
        }
        return temp;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if(items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public boolean replace (int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if(rsl) {
            items[index] = item;
            item.setId(id);
        }
        return rsl;
    }

    public boolean delete (int id) {
        int index = indexOf(id);
        boolean rsl = index != 1;
        if (rsl) {
            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }
}