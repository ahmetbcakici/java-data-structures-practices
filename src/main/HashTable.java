package main;

import java.util.ArrayList;

public class HashTable {
    private int INITIAL_SIZE = 16;
    private HashEntry[] data; // kinda array of LinkedList

    private static class HashEntry {
        private String key;
        private String value;
        private HashEntry next;

        private HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public HashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }

    public void put(String key, String value) {
        var hashEntry = new HashEntry(key, value);

        var index = getIndex(key);

        if (data[index] == null) {
            data[index] = hashEntry;
        } else {
            HashEntry entries = data[index];

            while (entries.next != null) {
                entries = entries.next;
            }

            entries.next = hashEntry;
        }
    }

    public String get(String key) {
        var index = getIndex(key);

        HashEntry entries = data[index];

        while (entries != null) {
            if (entries.key.equals(key)) {
                return entries.value;
            }
            entries = entries.next;
        }

        return null;
    }

    public void remove(String key) {
        var index = getIndex(key);

        HashEntry entries = data[index];

        if (entries.key.equals(key)) {
            data[index] = entries.next;
            return;
        }

        while (entries.next != null) {
            if (entries.next.key.equals(key)) {
                entries.next = entries.next.next;
                return;
            }
            entries = entries.next;
        }
    }

    public ArrayList<String> keys() {
        ArrayList<String> keys = new <String>ArrayList();

        for (int i = 0; i < INITIAL_SIZE; i++) {
            HashEntry entries = data[i];

            while (entries != null) {
                keys.add(entries.key);

                entries = entries.next;
            }
        }

        return keys;
    }

    private int getIndex(String key) {
        int hashCode = key.hashCode();

        int index = (hashCode & 0x7fffffff) % INITIAL_SIZE;

        // Hack to force collision for testing
        if (key.equals("John Smith") || key.equals("Sandra Dee") || key.equals("Tim Lee")) {
            index = 4;
        }

        return index;
    }

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : data) {
            if (entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while (temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }
}
