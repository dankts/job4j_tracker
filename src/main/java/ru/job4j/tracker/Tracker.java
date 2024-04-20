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
        int newSize = 0;
        Item[] result = new Item[size];
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (key.equals(item.getName())) {
                newSize++;
                result[i] = item;

            }
        }
        return Arrays.copyOf(result, newSize);
    }

    public Item findById(int id) {
        int indexId = indexOf(id);
        return indexId != -1 ? items[indexId] : null;
    }

    public boolean replace(int id, Item item) {
        int indexId = indexOf(id);
        if (indexId != -1) {
            item.setId(id);
            items[indexId] = item;
            return true;
        }
        return false;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return;
        }
        int start = index + 1;
        int length = size - index - 1;
        System.arraycopy(items, start, items, index, length);
        items[size - 1] = null;
        size--;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }
}