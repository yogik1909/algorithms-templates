package sprint4.A;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class A {
    public static void main(String[] args) throws IOException {
        int n;
        String data;
        Map<String, Integer> map = new Map<>();
        Integer val;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                data = reader.readLine();
                 if ((val = map.get(data)) != null){
                    map.set(data, val+1);
                 }else {
                     map.set(data, 1);
                 };


            }
        }
        for (Pair<String, Integer> item: map){
            System.out.println(item.key);
        }
    }
}
class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
class Map<K, V> implements Iterable<Pair<K, V>> {
    private List<Pair<K, V>> pairs;

    public Map() {
        pairs = new ArrayList<>();
    }

    public V get(K key) {
        for (Pair<K, V> pair : pairs) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return null; // Если пара не найдена, вернем null
    }

    public void set(K key, V value) {
        for (Pair<K, V> pair : pairs) {
            if (pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        }
        // Если пара с заданным ключом не найдена, добавим новую пару
        Pair<K, V> newPair = new Pair<>(key, value);
        pairs.add(newPair);
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return pairs.iterator();
    }

    public int getCountItem(){
        return pairs.size();
    }
}
