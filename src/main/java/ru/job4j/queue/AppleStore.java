package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {

    private final Queue<Customer> queue;
    private int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String result = null;
        for (Customer customer : queue) {
            count--;
            if (count <= 0) {
                result = customer.name();
                break;
            }
        }
        return result;
    }

    public String getFirstUpsetCustomer() {
        String result = null;
        for (Customer customer : queue) {
            count--;
            if (count == -1) {
                result = customer.name();
                break;
            }
        }
        return result;
    }
}
