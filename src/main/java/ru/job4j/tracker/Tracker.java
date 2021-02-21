package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public final class Tracker {
    private static Tracker instance = null;
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    //Create item
  public Item add(Item item) {
          item.setId(ids++);
          items.add(item);
      return item;
  }

    //Find all
    public List<Item> findAll() {
        return items;
    }

    //Find by name
    public List<Item> findByName(String key) {
        List<Item> temp = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                temp.add(item);
            }
        }
        return temp;
    }

        //Find by ID
        public Item findById(int id) {
        int index = indexOf(id);
            return index != -1 ? items.get(index) : null;
        }

        //Find Index
        public int indexOf(int id) {
        int rsl = -1;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getId() == id) {
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
                items.set(index, item);
                items.get(index).setId(id);
            }
            return rsl;
        }

        //Delete by ID
        public boolean delete(int id) {
            int index = indexOf(id);
            boolean rsl = index != -1;
            if (rsl) {
                items.remove(index);
            }
            return rsl;
        }
    }