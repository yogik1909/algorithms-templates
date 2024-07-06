//Задача: https://contest.yandex.ru/contest/25597/problems/A/
//Посылка: https://contest.yandex.ru/contest/25597/run-report/115887475/

/*
Нужно посчитать стоимость операций редактирования последовательнотей для превращения одной последовательности в другую

Димамика будет храниться в двух-строковом массиве, количетсво стоблцов m + 1.
Одна строка хранит расчитанные данные, во второй происходит расчет перехода
Для расчета индрекса массива рачитываемая строка возмем формулу i % 2 - curLine
Для предыдущей строки с предрасчитанными данными  (i - 1) % 2 - prevLine

Базовый случай
dp[0][j] = j;
dp[curLine][0] - i

Переход по динамиме будет осуществляться полученим минмальной стоимости операции превращения исохдч из предшествующих
расчетов построчно
Для одинаковых символов стоимость редактирования нулевая поэтому берется стоимость редактирования префикса
Для различных симоволо

min(
dp[prevLine][j] + 1 - операция удаления
dp[curLine][j - 1] + 1 - операция вставки
dp[prevLine][j - 1] + 1 операция замены
)

Порядок вычисления прямой построчно сверху в них

Резльтирующая ячейка - текущая строка обработанная в последней интерации, находящейстя на m позиции в строке

Вычислительная сложность алгоритма Левенштейна O(n * m)
Просстранственная сложность алгоритма O(m), для хранения динами нам требуется две строки, строка перехода и строка
расчетов на предыдущей иттерации

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
