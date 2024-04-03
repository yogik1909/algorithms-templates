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
    private Integer x;
    private boolean isFull;
    private boolean isEmpty;
    private int curIndex;



    public MyQueueSized(int max_size) {
        queue = new Integer[max_size];
        head = 0;
        tail = 0;
        max_n = max_size;
        size = 0;
        isEmpty = true;
        isFull = false;

    }

    public boolean isEmpty() {
        return isEmpty;
    }
    private void push(boolean proc, Integer value){
        //true - back
        //false - front
        if (isFull) {
            System.out.println("error");
            return;
        }
        size++;
        isFull = size == max_n;
        if (head == tail & isEmpty) {
            queue[tail] = value;
            isEmpty = false;
            return;
        }

        if (proc){
            curIndex = (tail + 1) %  max_n;
            tail = curIndex;
        }
        else{
            curIndex = myModulo(head - 1, max_n);
            head = curIndex;
        }

        queue[curIndex] = value;
    }

    public void push_back(int x) {
        push(true, x);
    }

    public void push_front(int x) {
        push(false, x);
    }

    public Integer pop(boolean proc){
        if (isEmpty) {
            System.out.println("error");
            return null;
        }
        if (size == 1) {
            isEmpty = true;
            size--;
            x = queue[tail];
            queue[tail] = null;
            System.out.println(x);
            return x;
        }
        int curIndex = proc?tail:head;
        size--;
        isFull = size == max_n;
        x = queue[curIndex];
        queue[curIndex] = null;
        if (proc)
            tail = myModulo(curIndex - 1, max_n);
        else
            head = curIndex + 1 % max_n;
        System.out.println(x);
        return x;
    }
    public Integer pop_front() {
       return pop(false);
    }

    public Integer pop_back() {
      return pop(true);
    }
    private int myModulo(int x, int y){
        int r = x % y;
        if (r < 0) r += y;
        return r;
    }
}

public class A {
    public static void main(String[] args) throws IOException {
        Pattern p = Pattern.compile("([a-z_]+)\\s*(-*\\d*)");
        Matcher m;
        int curVal;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            //StringBuilder stringBuilder = new StringBuilder("");
            int n = Integer.parseInt(reader.readLine());
            MyQueueSized query = new MyQueueSized(Integer.parseInt(reader.readLine()));
            for (int i = 0; i < n; i++) {
                m = p.matcher(reader.readLine());
                m.find();
                switch (m.group(1)) {
                    case "push_back": {
                        query.push_back(Integer.valueOf(m.group(2)));
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

