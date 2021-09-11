package main;

public class HashTable {
    private int INITIAL_SIZE = 16;
    private HashEntry[] data; // LinkedList

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

    private int getIndex(String key) {
        // Get the hash code
        int hashCode = key.hashCode();

        // Convert to index
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
            if(entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while(temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }

}
