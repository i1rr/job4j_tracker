package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    //Create item
    public Item add(Item item) {
        if (size < 100) {
            item.setId(ids++);
            items[size++] = item;
        } else {
            return null;
        }
        return items[size - 1];
    }

    //Find all
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    //Find by name
    public Item[] findByName(String key) {
        int arraySize = 0;
        int counter = 0;
        Item[] temp = new Item[size];
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                    temp[counter++] = items[i];
                    arraySize++;
                }
            }
            return Arrays.copyOf(temp, arraySize);
        }

        //Find by ID
        public Item findById(int id) {
            int index = indexOf(id);
            return index != -1 ? items[index] : null;
        }

        //Find Index
        private int indexOf(int id) {
            int rsl = -1;
            for (int i = 0; i < size; i++) {
                if (items[i].getId() == id) {
                    rsl = i;
                    break;
                }
            }
            return rsl;
        }

        //Edit by ID
        public boolean replace(int id, Item item) {
            int index = indexOf(id);
            boolean rsl = index != -1;
            if (rsl) {
                items[index] = item;
                items[index].setId(id);
            }
            return rsl;
        }

        //Delete by ID
        public boolean delete(int id) {
            int index = indexOf(id);
            boolean rsl = index != -1;
            if (rsl) {
                System.arraycopy(items, index + 1, items, index, size - index);
                items[size - 1] = null;
                size--;
            }
            return rsl;
        }
    }