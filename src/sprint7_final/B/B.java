//Задача: https://contest.yandex.ru/contest/25597/problems/B/
//https://contest.yandex.ru/contest/25597/run-report/115755390/

/*
Для решения будет использоваться метод динамического программирования
Задача, разделить элементы на 2 группы, так что бы сумма элементво этих групп была равна половине суммы всех элементов,
назовем его mid
Для этого найдем величину половины суммы всех элементов, если она нечетная, решение задачи не достижимо.

Далее необходимо проверить достижимо величины половины суммы всех лементов.
Для этого создадим массв динамики размеростью mid + 1
Каждый элемент будет хранить факт получения суммы при добавлении элемента массива
Базовый случа dp[0] = true
Преходом буде являться формула
dp[i] = dp[i] || dp[i - curScore];
Операция дизьюнкции используется потому что необходимо обновлять данные ячейки
Обход динамики реверсивный, при добавлении нового элемента проверяется достижимость mid с правого конца
Результать будет храниться в яейке dp[mid], т.е. в крайней правой ячейке.

Вычислительная сложность алгоритма
O(n * mid), это получается из-за последовательного перебора значений и вложеного цикла доствижения сумм этих элементов

Пространственая сложност
Дополнительно для получения результата алгоритму потребуется О(mid) памяти


 */

package sprint7_final.B;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] score = new int[n];
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            score[i] = scanner.nextInt();
            totalSum += score[i];
        }
        scanner.close();
        int mid = totalSum >> 1;
        //Если сумма не четная, поделить поровну точно не получится
        if ((mid + mid) != totalSum){
            System.out.println("False");
            return;
        }

        boolean[] dp = new boolean[mid + 1];
        //Нуль всегда достижим
        dp[0] = true;

        for (int curScore : score){
            for (int i = mid; i >= curScore; i--) {
                dp[i] = dp[i] || dp[i - curScore];
            }
        }
        System.out.println(dp[mid] ? "True" : "False");
    }


}
