package sprint5.I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class I {

    public static void main(String[] args) throws IOException {
        int n;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            n = Integer.parseInt(reader.readLine());
        }

        System.out.println(CatlanNumber(n));
    }

    private static int CatlanNumber(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
}
