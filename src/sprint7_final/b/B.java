package sprint7_final.b;

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

        dp[0] = true;

        for (int curScore : score){
            for (int i = mid; i >= curScore; i--) {
                dp[i] = dp[i] || dp[i - curScore];
            }
        }
        System.out.println(dp[mid] ? "True" : "False");
    }


}
