package sprint2.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackMax {
    static LinkedList<Integer> STACK = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Pattern p = Pattern.compile("([a-z_]+)\\s*(-*\\d*)");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                String comand = reader.readLine();
                Matcher m = p.matcher(comand);
                m.find();
                switch (m.group(1)) {
                    case "pop": {
                        try {
                            STACK.pop();
                        } catch (NoSuchElementException e) {
                            System.out.println("error");
                        }
                        break;
                    }
                    case "push": {
                        STACK.push(Integer.parseInt(m.group(2)));
                        break;
                    }
                    case "get_max": {
                        if (STACK.isEmpty()) {
                            System.out.println("None");
                        } else
                            System.out.println(Collections.max(STACK));
                        break;
                    }
                    case "top": {
                        if (STACK.isEmpty())
                            System.out.println("error");
                        else
                            System.out.println(STACK.peekFirst());
                        break;
                    }
                }
            }
        }
    }

}
