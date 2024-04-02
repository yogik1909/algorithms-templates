package sprint2.L;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class L {
    public static int commit(int n) {

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(1);
        for (int i = 2; i < n; i++){
            stack.push(stack.peekFirst() + stack.pollLast());
        }
        return stack.peekFirst() + stack.pollLast();
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
