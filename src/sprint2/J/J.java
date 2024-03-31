package sprint2.J;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MyQueueSized {
    private LinkedList<Integer> queue;
    public MyQueueSized() {
        queue = new LinkedList<Integer>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public Integer get(){
        Integer ret = null;
        if (!queue.isEmpty()) ret = queue.pollFirst();
        System.out.println(ret == null?"error":ret);
        return ret;
    }
    public void put(int x) {
        queue.add(x);
    }
    public int size(){
        System.out.println(this.queue.size());
        return this.queue.size();
    }
}
public class J {
    public static void main(String[] args) throws IOException {
        Pattern p = Pattern.compile("([a-z_]+)\\s*(-*\\d*)");
        Matcher m;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            MyQueueSized query = new MyQueueSized();
            for (int i = 0; i < n; i++) {
                m = p.matcher(reader.readLine());
                m.find();
                switch (m.group(1)) {
                    case "put": {
                        query.put(Integer.parseInt(m.group(2)));
                        break;
                    }
                    case "size":{
                        query.size();
                        break;
                    }
                    case "get": {
                        query.get();
                    }

                }
            }

        }
    }
}
