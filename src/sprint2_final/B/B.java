package sprint2_final.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;


public class B {

    public static void main(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            Scanner sc = new Scanner(reader.readLine());

            sc.useDelimiter(" ");
            Stack<Integer> stack = new Stack<>();
            while (sc.hasNext()){
                if (sc.hasNextInt()){
                    stack.push(sc.nextInt());
                    continue;
                }
                switch (sc.next()) {
                    case "+": {
                        stack.push(stack.pop() + stack.pop());
                        break;
                    }
                    case "*": {
                        stack.push(stack.pop() * stack.pop());
                        break;
                    }
                    case "/":{
                        int divider = stack.pop();
                        stack.push((int) Math.floor((double) stack.pop()  / (double) divider));
                        break;
                    }
                    case "-":{
                        int deductible = stack.pop();
                        stack.push(stack.pop() - deductible);
                        break;
                    }

                }

            }
        System.out.println(stack.pop());

        }

    }
}
