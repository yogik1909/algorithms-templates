package sprint1_nonfinals;

import java.util.Scanner;

public class B {

    private static boolean checkParity(int a, int b, int c) {
        int[] arr = new int[]{a,b,c};
        int ans = 0;
        for (int i : arr){
            if (i % 2 == 0) ans++;
            else ans--;
        }
        return Math.abs(ans) == 3?true:false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (checkParity(a, b, c)) {
            System.out.println("WIN");
        } else {
            System.out.println("FAIL");
        }
        scanner.close();
    }
    
}