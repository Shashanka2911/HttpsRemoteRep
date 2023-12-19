import java.util.LinkedList;

class HashTable {
    private static final int TABLE_SIZE = 10;
    private LinkedList<KeyValue>[] table;

    // Constructor
    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int hash(String key) {
        return Math.abs(key.hashCode() % TABLE_SIZE);
    }

    // Insert a key-value pair into the hash table
    public void insert(String key, int value) {
        int index = hash(key);
        LinkedList<KeyValue> list = table[index];

        // Check if the key already exists in the list
        for (KeyValue kv : list) {
            if (kv.key.equals(key)) {
                // Update the value if the key already exists
                kv.value = value;
                return;
            }
        }

        // Add a new key-value pair to the list
        list.add(new KeyValue(key, value));
    }

    // Retrieve the value associated with a key from the hash table
    public int get(String key) {
        int index = hash(key);
        LinkedList<KeyValue> list = table[index];

        // Search for the key in the list
        for (KeyValue kv : list) {
            if (kv.key.equals(key)) {
                return kv.value; // Key found, return the associated value
            }
        }

        return -1; // Key not found
    }

    // Inner class representing a key-value pair
    private static class KeyValue {
        String key;
        int value;

        // Constructor
        public KeyValue(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

public class HashingExample {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        // Insert key-value pairs into the hash table
        hashTable.insert("John", 25);
        hashTable.insert("Alice", 30);
        hashTable.insert("Bob", 35);

        // Retrieve values using keys
        System.out.println("John's age: " + hashTable.get("John"));
        System.out.println("Alice's age: " + hashTable.get("Alice"));
        System.out.println("Bob's age: " + hashTable.get("Bob"));
        System.out.println("Unknown person's age: " + hashTable.get("Unknown"));

        // Update the age of Alice
        hashTable.insert("Alice", 32);
        System.out.println("Updated Alice's age: " + hashTable.get("Alice"));
    }
}