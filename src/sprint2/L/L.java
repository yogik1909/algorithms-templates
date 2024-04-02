package sprint2.L;

import java.util.Scanner;

public class L {
    public static int commit(int n) {
        if (n < 0) return 0;
        switch (n){
            case 0: return 1;
            case 1: return 1;
            default: return commit(n-1) + commit(n -2);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ton = scanner.nextInt();
        int k = scanner.nextInt();
        int x = commit(ton);
        long bigInteger = Math.floorMod(x,(long) Math. round (Math.pow(10, k)));
        System.out.println(bigInteger);
    }
}
