// B. Эффективная быстрая сортировка
// https://contest.yandex.ru/contest/23815/problems/B/
// Посылка 1: Сортировка с выбором опортны элементом последний элемент последовательности
// https://contest.yandex.ru/contest/23815/run-report/112849449/
// Посылка 2: Сотрировка с выбором опорынм элементом средний элемент последовательности
// https://contest.yandex.ru/contest/23815/run-report/112965223/

/*
Мой алгоритм основан, как я понял, на классическом алгоритме быстрой сортировки in-place quick sortтолько переписанный
под структры применимые только к текущему условию задачи.
За основу взял статью https://javarush.com/groups/posts/bihstraja-sortirovka-quicksort-v-java (но данный алгоритм
описан схожим образом в различных источниках)
Т. е. в задачем нам требуется сортировка не приметивные значние, а Обьекты по их характристикам.
Для этого я создал класс Player, который описывает участников соревнования.
Класс обявил как реализующий интрфейс Comparable. Реализовал фунцию сравнения по заданным условиям на хужный и лучший.
Далее алгоритм модернизировал согласно используемой структуры данных.
Я вибираю опорный элемент(болше понравился алгоритм с выбором последнего элемента последовательности) и произвожу
оценку всех элементов последовательности отностительно опорного. Худший элемент перемещается в правую сторону лучший
в левую. Так как вывод результата будет начинаться с головы.
После обхода текущей последовательности, перемещаю опорный элемент на позицию где опорный элемент лучше предыдущего и
хуже последующего, этот индекс массива мы зафиксировали при стравнении и встаке эмементов.
Так как на этой итерации диапазоны шудших и лучших результатов относительно опорного не были остартированы между собой
необходимо рекурсивно вызвать сортировку диапазовнов. Базовым случаем будет иттерация когнда индесы леовй и правой гарници
будут ровны, что эквивалентно диапазону из одного элемента, а такой диапазон считается отсортированным.

-- Вычислительная сложность --
Так как из теритических занятий мы знаем что алгорит быстрой сортировки имеет
теритическую сложность O(n log n), которую сложно доказать или опровегнуть. Спорить с этим не будем.
-- Пространственная сложность --
Так как для сортировки  in-place не используется создание дополниельных структур
Пространственная сложность осимптотична О(n)
 */

package sprint3_final.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

    public static class QuickSort {

        public static void quickSort(Player[] array, int left, int right) {
            if (left < right) {
                int pivotIndex = partition(array, left, right);
                quickSort(array, left, pivotIndex - 1);
                quickSort(array, pivotIndex + 1, right);
            }
        }

        private static int partition(Player[] array, int left, int right) {
            Player pivot = array[right];
            int i = (left - 1);
            for (int j = left; j < right; j++) {
                if (array[j].compareTo(pivot) < 0) {
                    i++;
                    swap(array, i, j);
                }
            }
            swap(array, i + 1, right);
            return i + 1;
        }

        private static void swap(Player[] array, int i, int j) {
            Player temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        int n;
        Player[] players;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            n = Integer.parseInt(reader.readLine());
            players = new Player[n];
            for (int i = 0; i < n; i++) {
                String[] player = reader.readLine().split(" ");
                players[i] = new Player(player[0], Integer.parseInt(player[1]), Integer.parseInt(player[2]));
            }
        }
        QuickSort.quickSort(players, 0, players.length - 1);
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < players.length; i++) {
            sb.append(players[i].login).append("\n");
        }
        System.out.println(sb);



    }
    public static class Player  implements Comparable<Player> {
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
            resCompare = o.solve - this.solve;
             if (resCompare == 0)
                 resCompare = this.penalty - o.penalty;
             if (resCompare == 0)
                 resCompare = this.login.compareTo(o.login);

            return resCompare;
        }
    }
}


