// Задача B. Хеш-таблица
// https://contest.yandex.ru/contest/24414/problems/B/
// Посылка: https://contest.yandex.ru/contest/24414/run-report/113796466/

/*

Реализация хеш-таблицы, используя метод цепочек для разрешения коллизий.
Внутренний класс Entry: это структура, которая представляет элемент данных в хеш-таблице.
Он содержит реквизиты ключ, значение и ссылку на следующий элемент (для разрешения коллизий).
Метод hash: этот метод вычисления индекса в массиве для заданного ключа. Так как известно, что ключи в нашей задаче только числовые. Хэш-функция реализуется как остаток от деления по основанию объема хэш-таблицы. Если учесть условие ограничения, ключи не превышают значение 10^5, то при выборе объема хэш-таблицы аналогичной условия коллизии будут встречаться только для одинаковых по модулю ключей. Я для своей реализации выбрал объем хэш-таблицы, равной 10^3, считаю, что этого достаточно для получения вычислительной сложности O(1) в среднем.
Метод put: добавляет пару ключ-значение в таблицу. Если ключ уже существует, значение обновляется.
Метод get: возвращает значение по ключу. Если ключ не найден, возвращает null.
Метод delete: удаляет ключ из таблицы и возвращает значение. Если ключ не найден, возвращает null.

Эта реализация обеспечивает базовые операции хеш-таблицы с использованием метода цепочек для разрешения коллизий.
## Вычислительная сложность.
В худшем случае мы получим вычислительную сложность O(n) для методов put, get, delete, если ключи будут стоять
только из одинаковых по модулю чисел. В среднем случай вычислительная сложность составляет О(1)
Для примера: всего в коллекции 2 элемента и значения ключей принадлежат множеству {2, -2}.
В среднем для каждой операции вычислительная сложность O(1).
Так как реализация не подразумевает мастабирования карзины дня хранения значений мы не получим ухудшение времени при
переволнении или чрезмерном высвобождении карзины.

## Пространственная сложность
пространсвенную сложность собственой реализации Map можно оценить как О(n+m) где
 - n - количество вводимых пар значений
 - m - размер базового массива
 */


package sprint4_finale.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

    public static void main(String[] args) throws IOException {
        MyHashTable ht = new MyHashTable();
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

    public MyHashTable() {
        this.capacity = (int) Math.pow(10, 3);
        this.table = new Entry[capacity];
    }

    private int getBucketIndex(int key) {
        return  hash(key) % capacity;
    }
    private int hash(int key){
        return Math.abs(key);
    }
    public void put(int key, int value) {
        int index = getBucketIndex(key);
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
        int index = getBucketIndex(key);
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
        int index = getBucketIndex(key);
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
