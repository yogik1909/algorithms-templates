package sprint7_final.A;


import java.util.Scanner;

class LevenshteinDistance {
    public static int levenshteinDistance(String s, String t) {
        //Получить длинну строк
        int n = s.length();
        int m = t.length();
        //Определяем массив динамики
        int[][] dp = new int[n + 1][m + 1];

        // Инициализация первой строки и первого столбца
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // Заполнение матрицы стймостей
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Символы равны, стоимость 0
                } else {                // Операция удаления
                    int min = Math.min(dp[i - 1][j] + 1,
                            // Операция добавления
                            dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(min,
                            // Операция замены
                            dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[n][m];
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
