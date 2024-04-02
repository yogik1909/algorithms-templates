package sprint2_final.A;

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

    public void push_back(int x) {
        if (size != max_n) {
            tail = (tail + 1) % max_n;
            queue[tail] = x;
            size++;
        } else System.out.println("error");
    }

    public void push_front(int x) {
        if (size != max_n) {
            head = Math.floorMod((head - 1), max_n);
            queue[head] = x;
            size++;
        } else System.out.println("error");
    }

    public Integer pop_front() {
        if (isEmpty()) {
            System.out.println("error");
            return null;
        }
        Integer x = queue[head];
        queue[head] = null;
        head = Math.floorMod((head + 1), max_n);
        size--;
        System.out.println(x);
        return x;
    }

    public Integer pop_back() {
        if (isEmpty()) {
            System.out.println("error");
            return null;
        }
        Integer x = queue[tail];
        queue[tail] = null;
        tail = Math.floorMod((tail - 1), max_n);
        size--;
        System.out.println(x);
        return x;
    }

}

public class A {
    public static void main(String[] args) throws IOException {
        Pattern p = Pattern.compile("([a-z_]+)\\s*(-*\\d*)");
        Matcher m;
        int curVal;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder stringBuilder = new StringBuilder("");
            int n = Integer.parseInt(reader.readLine());
            MyQueueSized query = new MyQueueSized(Integer.parseInt(reader.readLine()));
            for (int i = 0; i < n; i++) {
                m = p.matcher(reader.readLine());
                m.find();
                switch (m.group(1)) {
                    case "push_back": {
                        query.push_back(Integer.parseInt(m.group(2)));
                        break;
                    }
                    case "push_front": {
                        query.push_front(Integer.parseInt(m.group(2)));
                        break;
                    }
                    case "pop_back": {
                        query.pop_back();
                        break;
                    }
                    case "pop_front": {
                        query.pop_front();
                        break;
                    }
                }
            }
        }
    }
}

