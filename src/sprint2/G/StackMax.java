package sprint2.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackMax {
    static LinkedList<Integer> STACK = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++){
                parseComant(reader.readLine());
            }
        }
    }

    static void parseComant(String comand){
        if (comand.startsWith("pop")) {
           String[] comOper = comand.split(" ");
           try{STACK.pop();}
           catch (NoSuchElementException e){
               System.out.println("error");
               return;
           }
        }
        if (comand.startsWith("push")){
            String[] comOper = comand.split(" ");
            STACK.push(Integer.parseInt(comOper[1]));
            return;
        }
        if (comand.equals("get_max")){
            if(STACK.isEmpty()){
                System.out.println("None");
            }
            else
                System.out.println(Collections.max(STACK));
            return;
        }
        if(comand.equals("top")){
            if (STACK.isEmpty())
                System.out.println("error");
            else
                System.out.println(STACK.peekFirst());
            return;
        }

    }
}
