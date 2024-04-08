//https://contest.yandex.ru/contest/22781/run-report/111621033/
/*
-- ПРИНЦИП РАБОТЫ --
Реализая двустронней очереди на замкнутом буфере.
Алгортм работае исходя из 2 указателей на текущую позищию последнего вставленного эемента в буфер.
Помещать из извлекать эелменты можно как в начало очереди так и в конец очереди, так как используется замкнутый буфер,
размерность очереди имеет ограничении, задаваемое при инифиализации очереди.


-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Так как для в данном алгоритме я буду испольовать 2 указателя на противоположные вершины буфера
я смогу ивлекать и помещать элементы в обоих направлениях. Особый случай это полностью пустой буфер и буфер с одним
значением, в этом состоянии указателя индексируют один и тот же элемент буфера, для решения этой коллизии введены
описывающие состояние пустого буфера.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --

Так как мы используем замкнутый буфер, в случае переполнения буфера не произойдет релокации пула, что могло увеличить
сложность алгоритма до О(N!).
Поэтому сожноть алгоритма линейно зависит от количесва операций производимых в элементами буфера O(K)
так как операции ввода и извлечения константны сами по себе т. е. O(1)


 -- Пространственная сложность --
 Что касательно пространственной сложности алгоритма, она зависит линейно от входных параметров, так как мы используем
 замкнутый буфер(массив), т. е. при переполнении буфера не портебудется вделение памяти для релокации этого буфера.
 Но с учетом моей реализации и буферизации вывода в лог простанстванная сложность увеличится на
 K оераий который будт производиться над очередь.
 То есть без лога пространсвенная сложность будет O(N), моя реализация будет O(K + N)

 */

package sprint2_final.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MyQueueSized {
    private Integer[] queue;
    private int head;
    private int tail;
    private int max_n;
    private int size;
    private Integer x;
    private boolean isFull;
    private boolean isEmpty;
    private StringBuilder log;



    public MyQueueSized(int max_size) {
        queue = new Integer[max_size];
        head = 0;
        tail = 0;
        max_n = max_size;
        size = 0;
        isEmpty = true;
        isFull = false;
        log = new StringBuilder("");

    }

    public boolean isEmpty() {
        return isEmpty;
    }
    private void push(boolean proc, Integer value){
        //true - back
        //false - front
        if (isFull) {
            log.append("error").append('\n');
            return;
        }
        size++;
        isFull = size == max_n;
        if (head == tail & isEmpty) {
            queue[tail] = value;
            isEmpty = false;
            return;
        }

        int curIndex = Math.floorMod(proc?(tail + 1):(head - 1), max_n);
        if (proc)
            tail = curIndex;
        else
            head = curIndex;

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
            log.append("error").append('\n');
            return null;
        }
        if (size == 1) {
            isEmpty = true;
            size--;
            x = queue[tail];
            queue[tail] = null;
            log.append(x).append('\n');
            return x;
        }
        int curIndex = proc?tail:head;
        size--;
        isFull = size == max_n;
        x = queue[curIndex];
        queue[curIndex] = null;
        if (proc)
            tail = Math.floorMod(curIndex - 1, max_n);
        else
            head = (curIndex + 1) % max_n;
        log.append(x).append('\n');
        return x;
    }
    public Integer pop_front() {
       return pop(false);
    }

    public Integer pop_back() {
      return pop(true);
    }

    public String getLog(){
        return log.toString();
    }
}

public class A {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            MyQueueSized query = new MyQueueSized(Integer.parseInt(reader.readLine()));
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(reader.readLine());
                switch (st.nextToken()) {
                    case "push_back": {
                        query.push_back(Integer.parseInt(st.nextToken()));
                        break;
                    }
                    case "push_front": {
                        query.push_front(Integer.parseInt(st.nextToken()));
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
            System.out.println(query.getLog());
        }
    }
}

