package com.example.shoppinglist;

import java.util.ArrayList;
import java.util.Comparator;

public class Storage {
    protected static ArrayList<Item> items = new ArrayList<>();
    private static Storage storage = null;

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public static void addItem(Item item) {
        items.add(item);
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public void deleteItem(Item item) {
        int i = 0;
        for (Item j : items) {
            if (j.getName().equals(item.getName()) && j.getNote().equals(item.getNote())) {
                break;
            }
            i++;
        }
        items.remove(i);
    }

    Comparator<Item> nameComparator = new Comparator<Item>() {
        public int compare(Item p1, Item p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };

};

