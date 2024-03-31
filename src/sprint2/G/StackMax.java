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
    static LinkedList<Integer> MAX_STACK = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Pattern p = Pattern.compile("([a-z_]+)\\s*(-*\\d*)");
        Matcher m;
        int max_val = Integer.MIN_VALUE;
        int curVal;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder stringBuilder = new StringBuilder("");
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                m = p.matcher(reader.readLine());
                m.find();
                switch (m.group(1)) {
                    case "pop": {
                        try {
                           STACK.pop();
                           MAX_STACK.pop();
                        } catch (NoSuchElementException e) {
                            stringBuilder.append("error").append("\n");
                        }
                        break;
                    }
                    case "push": {
                        curVal = Integer.parseInt(m.group(2));
                        if (!MAX_STACK.isEmpty())
                            MAX_STACK.push(Math.max(MAX_STACK.peek(), curVal));
                        else
                            MAX_STACK.push(curVal);

                        STACK.push(curVal);
                        break;
                    }
                    case "get_max": {
                        if (!MAX_STACK.isEmpty())
                            stringBuilder.append(MAX_STACK.peek()).append("\n");
                        else
                            stringBuilder.append("None").append("\n");
                        break;
                    }
                    case "top": {
                        if (STACK.isEmpty()) {
                            stringBuilder.append("error").append("\n");
                        }
                        else
                            stringBuilder.append(STACK.peekFirst()).append("\n");
                        break;
                    }
                }
            }
            System.out.println(stringBuilder);
        }
    }

}
