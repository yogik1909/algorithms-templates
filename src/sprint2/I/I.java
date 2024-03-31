package sprint2.I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MyQueueSized {
    private Integer[] queue;
    private int head;
    private int tail;
    private int max_n;
    private int size;
    public MyQueueSized(int max_size) {
        queue = new Integer[max_size];
        head = 0;
        tail = 0;
        max_n = max_size;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int x) {
        if (size != max_n) {
            queue[tail] = x;
            tail = (tail + 1) % max_n;
            size++;
        }
        else System.out.println("error");
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("None");
            return null;
        }
        Integer x = queue[head];
        queue[head] = null;
        head = (head + 1) % max_n;
        size--;
        System.out.println(x);
        return x;
    }
    public void peek(){
        if (isEmpty()) {
            System.out.println("None");
            return;
        }
        System.out.println(queue[head]);
    }
    public int size(){
        System.out.println(this.size);
        return this.size;
    }
}
public class I {
    public static void main(String[] args) throws IOException {
        Pattern p = Pattern.compile("([a-z_]+)\\s*(-*\\d*)");
        Matcher m;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            MyQueueSized query = new MyQueueSized(Integer.parseInt(reader.readLine()));
            for (int i = 0; i < n; i++) {
                m = p.matcher(reader.readLine());
                m.find();
                switch (m.group(1)) {
                    case "pop": {
                        query.pop();
                        break;
                    }
                    case "push": {
                        query.push(Integer.parseInt(m.group(2)));
                        break;
                    }
                    case "size":{
                        query.size();
                        break;
                    }
                    case "peek":{
                        query.peek();
                        break;
                    }
                }
            }

        }
    }


}
