package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {

    private final List<Item> items = new ArrayList<>(100);
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(int id) {
        int indexId = indexOf(id);
        return indexId != -1 ? items.get(indexId) : null;
    }

    public boolean replace(int id, Item item) {
        int indexId = indexOf(id);
        if (indexId != -1) {
            item.setId(id);
            items.set(indexId, item);
            return true;
        }
        return false;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return;
        }
        items.remove(index);
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }
}