package sprint2.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class STC {
    public int val;
    public int max;
    public STC(int val, int max) {
        this.max = max;
        this.val = val;
    }
}
public class StackMax {
    static LinkedList<STC> STACK_2 = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Pattern p = Pattern.compile("([a-z_]+)\\s*(-*\\d*)");
        Matcher m;
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
                           STACK_2.pop();
                        } catch (NoSuchElementException e) {
                            stringBuilder.append("error").append("\n");
                        }
                        break;
                    }
                    case "push": {
                        curVal = Integer.parseInt(m.group(2));
                        try {
                            STACK_2.push(new STC(curVal, Math.max(STACK_2.peek().max, curVal)));
                        }
                        catch (NullPointerException e){
                            STACK_2.push(new STC(curVal, curVal));
                        }
                        break;
                    }
                    case "get_max": {
                        if (!STACK_2.isEmpty())
                            stringBuilder.append(STACK_2.peek().max).append("\n");
                        else
                            stringBuilder.append("None").append("\n");
                        break;
                    }
                    case "top": {
                        if (STACK_2.isEmpty()) {
                            stringBuilder.append("error").append("\n");
                        }
                        else
                            stringBuilder.append(STACK_2.peekFirst().val).append("\n");
                        break;
                    }
                }
            }
            System.out.println(stringBuilder);
        }
    }

}
