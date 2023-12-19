import java.util.LinkedList;

class MyHashMap<K, V> {
    private static final int TABLESIZE = 10;

    private LinkedList<Entry<K, V>>[] table;

    public MyHashMap() {
        table = new  LinkedList[TABLESIZE];
        for (int i = 0; i < TABLESIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int hash = hash(key);
        LinkedList<Entry<K, V>> bucket = table[hash];

        // Check if the key already exists in the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        // If the key is not found, add a new entry
        bucket.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int hash = hash(key);
        LinkedList<Entry<K, V>> bucket = table[hash];

        // Search for the key in the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null; // Key not found
    }

    private int hash(K key) {
        // Simple hash function for demonstration purposes
        return key.hashCode() % TABLE_SIZE;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

public class HashMap {
    public static void main(String[] args) {
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();

        hashMap.put("John", 25);
        hashMap.put("Alice", 30);
        hashMap.put("Bob", 22);

        System.out.println("John's age: " + hashMap.get("John")); // Output: 25
        System.out.println("Alice's age: " + hashMap.get("Alice")); // Output: 30
        System.out.println("Bob's age: " + hashMap.get("Bob")); // Output: 22
        System.out.println("Unknown key's value: " + hashMap.get("Unknown")); // Output: null
    }
}
