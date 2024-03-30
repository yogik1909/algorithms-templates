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
                           curVal = STACK.pop();
                           if (STACK.isEmpty()){
                               max_val = Integer.MIN_VALUE;
                           } else if (curVal == max_val)
                               max_val = Collections.max(STACK);
                        } catch (NoSuchElementException e) {
                            stringBuilder.append("error").append("\n");
                        }
                        break;
                    }
                    case "push": {
                        curVal = Integer.parseInt(m.group(2));
                        max_val = Math.max(max_val, curVal);
                        STACK.push(curVal);
                        break;
                    }
                    case "get_max": {
                        if (STACK.isEmpty()) {
                            stringBuilder.append("None").append("\n");
                        } else
                            stringBuilder.append(max_val).append("\n");
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
