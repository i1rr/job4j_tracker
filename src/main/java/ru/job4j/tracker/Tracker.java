package ru.job4j.tracker;

import java.util.ArrayList;

public final class Tracker {
    private static Tracker instance = null;
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;

    private Tracker() {
    }

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
      return items.get(indexOf(ids -1));
  }

    //Find all
    public ArrayList<Item> findAll() {
        return items;
    }

    //Find by name
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> temp = new ArrayList<>();
        for(Item item : items) {
            if(item.getName().equals(key)) {
                temp.add(item);
            }
        }
        return temp;
    }

        //Find by ID
        public Item findById(int id) {
            return items.get(indexOf(id));
        }

        //Find Index
        public int indexOf(int id) {
        int rsl = -1;
        for(Item item : items) {
            if(item.getId() == id) {
                rsl = items.indexOf(item);
                break;
            }
        }
            System.out.println(rsl);
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