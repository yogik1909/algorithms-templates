//Задача: https://contest.yandex.ru/contest/25597/problems/A/
//Посылка: https://contest.yandex.ru/contest/25597/run-report/115751677/

/*
Нужно посчитать стоимость операций редактирования последовательнотей для превращения одной последовательности в другую

Димамика будет храниться в двумерном массиве
Одна последовательность будет предствалена горзонтально, вторая вертикально
Базовый случай
dp[i][0] = i;
dp[0][j] = j;
Хранит исходные стоимости превращения последовательностей

Переход по динамиме будет осуществляться полученим минмальной стоимости операции превращения исохдч из предшествующих
расчетов построчно
Для одинаковых символов стоимость редактирования нулевая поэтому берется стоимость редактирования префикса
Для различных симоволо

min(
dp[i - 1][j] + 1 - операция удаления
dp[i][j - 1] + 1 - операция вставки
dp[i - 1][j - 1] + 1 операция замены
)

Порядок вычисления прямой построчно сверху в них

Резльтирующая ячейка - нижняя правая



Вычислительная сложность алгоритма Левенштейна O(n * m)
Просстранственная сложность алгоритма O(n * m)

 */
package sprint7_final.A;


import java.util.Scanner;

class LevenshteinDistance {
    public static int levenshteinDistance(String s, String t) {
        //Получить длинну строк
        int n = s.length();
        int m = t.length();
        //Определяем массив динамики
        int[][] dp = new int[2][m + 1];

        // Инициализация первой строки
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        int curLine = 1;
        // Заполнение матрицы стймостей
        for (int i = 1; i <= n; i++) {
            curLine = i % 2;
            int prevLine = (i - 1) % 2;
            dp[curLine][0] = i;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                                    // Символы равны, стоимость 0
                    dp[curLine][j] = dp[prevLine][j - 1];
                } else {
                    int min = Math.min(
                            // Операция удаления
                            dp[prevLine][j] + 1,

                            // Операция удаления
                            dp[curLine][j - 1] + 1);
                    dp[curLine][j] = Math.min(
                            min,
                            // Операция замены
                            dp[prevLine][j - 1] + 1);
                }
            }
        }

        return dp[curLine][m];
    }
}
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        LevenshteinDistance ld = new LevenshteinDistance();
        System.out.println(ld.levenshteinDistance(s, t));
    }
}
