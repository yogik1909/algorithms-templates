// Задача A. Поиск в сломанном массиве
// https://contest.yandex.ru/contest/23815/problems/A/
// Посылка: https://contest.yandex.ru/contest/23815/run-report/113759502/

/*
Реализация поиска в сломанном массиве следующая
Так как мы точно знаем, что исходный массив в кольцевом буфере был отсортирован по не убыванию относительно головы
буффера и в массив состоит только из уникальных значений, на потребуется найти голову сортированного массива.
Далее применим алгоритм бинарого поиска с четом уже двух полуинтервалов.
Алгоритмом поиска головы массива будет так же бинарный поиск


-- Доказательство корректности --
Так так бинарный поиск начинается с указаниия стартового интервавла, а в классическом случае это начало и конец
отсортированного массива.
Такой алгоритм удовлетворителен для нашего случая где массив разбит на 2 полуинтервала отсортированных массивов.

-- Временная сложность --
 Отграничением задачи является не превышения временной сложности O(log n).
 Это ограничение применимо к алгоритму бинарного поиска.
 Мой алгоритм усложняется второй иттерацией бинарного поиска головы отсортированного массива,
 которая так же осимптоматична O(log n).
 В итого получаем что алгоритм поиска в сломаном массиве отвечает требованию ограничения времени O(log n)

-- Пространственная сложность --
В этом алготме не используется дублирвоание полуинтервалов, операции производятся только над
индексами границ массива поэтому пространственная лсожното оссимптоматичная О(1)
 */

package sprint3_final.A;

public class Solution {
    public static int brokenSearch(int[] arr, int k) {

        int startInd;

        startInd = binarySearchMin(arr, 0, arr.length - 1);

        int resIndex = binarySearch(arr, k, 0, startInd);
        if (resIndex == -1) {
            resIndex = binarySearch(arr, k, startInd, arr.length);
        }

        return resIndex;

    }

    public static int binarySearchMin(int[] arr, int left, int right) {
        if (right - left + 1 > 2) {
            int mid = (left + right) >> 1;
            if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) return mid;
            if (arr[left] > arr[mid]) {
                return binarySearchMin(arr, left, mid);
            }
            return binarySearchMin(arr, mid, right);
        } else if (right - left + 1 == 2) {
            return arr[right] > arr[left] ? left : right;
        }
        return 0;
    }

    public static int binarySearch(int[] arr, int val, int left, int right) {
        if (right <= left) { // промежуток пуст
            return -1;
        }
        int mid = (left + right) >> 1;
        if (arr[mid] == val) {
            return mid;
        } else if (val < arr[mid]) {
            return binarySearch(arr, val, left, mid);
        } else {
            return binarySearch(arr, val, mid + 1, right);
        }
    }

    private static void test() {
        int[] arr = {5};
        //{19,    21,  100,    101,    1,  4,  5,  7,  12};
//        System.out.println(binarySearchMin(arr, 0, arr.length));

//        System.out.println("Seach: 4 = "+brokenSearch(arr, 4));
//        System.out.println("Seach: 100 = "+brokenSearch(arr, 100));
//        arr = new int[]{101,   1,   4,      5,      7,  12, 19, 21, 100};
//        System.out.println(binarySearchMin(arr, 0, arr.length));
//        arr = new int[]{100, 101, 1, 4, 5, 7, 12, 19, 21};
//        System.out.println(binarySearchMin(arr, 0, arr.length));
        System.out.println(brokenSearch(arr, 5));
//        arr = new int[] {5, 1};
//        System.out.println(brokenSearch(arr, 1));

    }

    public static void main(String[] args) {
        test();
    }
}
