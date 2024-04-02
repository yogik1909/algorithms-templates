package sprint2.K;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class K {
    public static int commit(int n) {
        if (n < 0) return 0;
        switch (n){
            case 0: return 1;
            case 1: return 1;
            default: return commit(n-1) + commit(n -2);
        }

    }
    public static void main(String[] args) {
        int ton = new Scanner(System.in).nextInt();
        System.out.println(commit(ton));
    }
}
