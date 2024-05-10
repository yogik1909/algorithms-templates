package sprint4_finale.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

    public static void main(String[] args) throws IOException {
        MyHashTable ht = new MyHashTable((int) Math.pow(10, 3));
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < n; i++) {
                String[] comandFrag = reader.readLine().split(" ");

                switch (comandFrag[0]) {
                    case "put": {
                        ht.put(Integer.parseInt(comandFrag[1]), Integer.parseInt(comandFrag[2]));
                        break;
                    }
                    case "delete": {
                        Integer val = ht.delete(Integer.parseInt(comandFrag[1]));
                        sb.append(val == null ? "None" : val).append("\n");
                        break;
                    }
                    case ("get"): {
                        Integer val = ht.get(Integer.parseInt(comandFrag[1]));
                        sb.append(val == null ? "None" : val).append("\n");
                        break;
                    }
                }

            }
            System.out.println(sb);
        }
    }
}

class MyHashTable {
    private class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Entry[] table;
    private int capacity;

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }

    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Entry newEntry = new Entry(key, value);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry current = table[index];
            Entry prev = null;
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }
            prev.next = newEntry;
        }
    }

    public Integer get(int key) {
        int index = hash(key);
        Entry current = table[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public Integer delete(int key) {
        int index = hash(key);
        Entry current = table[index];
        Entry prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }
}
