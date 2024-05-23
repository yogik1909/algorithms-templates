/*
Задача: https://contest.yandex.ru/contest/24810/problems/
Посылка: https://contest.yandex.ru/contest/24810/run-report/114459791/

Описание
Для решения задачи по сортировке списка игроков выбрал структуру приоритетной очереди.
Данная структура позволит хранить участников соревнований, а также получить отсортированный результат по
необходимым параметрам.
Для описания участников создан класс Playear. Для описания структуры приоритетной кучи реализован класс Heap.
## Вычислительная сложность
Создание объекта кучи оценивается как O(1), так как мы изначально знаем количество участников соревнования.
Добавление участника в кучу оценивается как O(log n) — общая оценка процесса вставки участника обходится
O(n log n).
Получение сортированного результирующего списка участников оценивается как O(n log n).
Общая вычислительная сложность O(1) + O(n log n) + O(n log n) асимптоматична O(n log n).
## Пространственная сложность
Так как для получения результата отсортированного списка участников по заданным параметрам мы используем
приоритетную очередь, дополнительно понадобится O(n) памяти для хранения.
Также для вывода на экран используется O(n) дополнительной памяти, если выводить результат построчно,
дополнительная память для хранения промежуточного итога не потребуется.
 */

package sprint5_final.A;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A {


    public static void main(String[] args) throws IOException {
        int n;
        Heap heap = new Heap();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                String[] player = reader.readLine().split(" ");
                heap.insert(new Player(player[0], Integer.parseInt(player[1]), Integer.parseInt(player[2])));
            }
        }

        StringBuilder sb = new StringBuilder("");
        Player maxPlayer;
        while ((maxPlayer = heap.getMax()) != null) {
            sb.append(maxPlayer.toString()).append("\n");
        }
        System.out.println(sb);

    }

    public static class Heap {
        private List<Player> heap;

        public Heap(int count) {
            this.heap = new ArrayList<>(count);
        }

        public void insert(Player newPlayer) {
            heap.add(newPlayer);
            siftUp(heap.size() - 1);
        }

        private void siftUp(int idx) {
            while (idx > 0) {
                int indexParent = (idx - 1) / 2;
                Player currentItem = heap.get(idx);
                Player parentItem = heap.get(indexParent);
                if (currentItem.compareTo(parentItem) < 0) {
                    swap(idx, indexParent);
                    idx = indexParent;
                } else {
                    break;
                }
            }
        }

        public Player getMax() {
            if (heap.size() == 0) {

                return null;
            }
            Player max = heap.get(0);
            Player lastItem = heap.remove(heap.size() - 1);
            if (heap.size() > 0) {
                heap.set(0, lastItem);
                siftDown(0);
            }
            return max;
        }

        private void siftDown(int index) {
            int lastIndex = heap.size() - 1;
            while (index < lastIndex) {
                int leftChildIndex = 2 * index + 1;
                int rightChildIndex = 2 * index + 2;
                int largestIndex = index;

                if (leftChildIndex <= lastIndex
                        && heap.get(leftChildIndex).compare(heap.get(leftChildIndex), heap.get(largestIndex)) < 0) {
                    largestIndex = leftChildIndex;
                }

                if (rightChildIndex <= lastIndex
                        && heap.get(rightChildIndex).compare(heap.get(rightChildIndex), heap.get(largestIndex)) < 0) {
                    largestIndex = rightChildIndex;
                }

                if (largestIndex != index) {
                    swap(index, largestIndex);
                    index = largestIndex;
                } else {
                    break;
                }
            }
        }

        private void swap(int i, int j) {
            Player temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }

    public static class Player implements Comparable<Player> {
        private String login;
        private int solve;
        private int penalty;

        public Player(String login, int solve, int penalty) {
            this.login = login;
            this.solve = solve;
            this.penalty = penalty;
        }

        @Override
        public int compareTo(Player o) {
            int resCompare;
            resCompare = Integer.compare(o.solve, this.solve);
            if (resCompare == 0)
                resCompare = Integer.compare(this.penalty, o.penalty);
            if (resCompare == 0)
                resCompare = login.compareTo(o.login);

            return resCompare;
        }

        @Override
        public String toString() {
            return login;
        }

        public int compare(Player currentItem, Player parentItem) {
            return currentItem.compareTo(parentItem);
        }
    }

}