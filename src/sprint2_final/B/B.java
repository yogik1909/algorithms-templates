//https://contest.yandex.ru/contest/22781/run-report/111628927/
/*
-- Принцип работы  и Доказательско корректности--
Органинизация процесса подсчета обратной польской нотации посредством использование стека
т.е. использоавния принципа LIFO
это значит что при получнии на входе знака мат. операции мы совершим эту операцию с 2 оперндами из вершины срека
значений введенных до знака мат. операции

-- Вычислительная сложность --
Доавление и звлечение эелмента занимает константное время
Таким образом в лучшем случае если не будет ни одной мат операции вермя вывода резульата будет
асимптоматично О(n)
На каждую операцию будет приходиться 2 доп извелечения и одно помещение занчений
В этом случае количество операций будет квадратичнымм
В самом худшем случаем мы получим вычислителную сложность O(n^2)

-- Пространственная сложность --
пространственная сложност будет равна количеству введенных значений, так как при выполнеии мат. оперпции стек усекается
и того в самом худшем варианте пространвтенная сложность будет асимптоматична O(3n)


 */

package sprint2_final.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;


public class B {

    public static void main(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            Scanner sc = new Scanner(reader.readLine());

            sc.useDelimiter(" ");
            Stack<Integer> stack = new Stack<>();
            while (sc.hasNext()){
                if (sc.hasNextInt()){
                    stack.push(sc.nextInt());
                    continue;
                }
                switch (sc.next()) {
                    case "+": {
                        stack.push(stack.pop() + stack.pop());
                        break;
                    }
                    case "*": {
                        stack.push(stack.pop() * stack.pop());
                        break;
                    }
                    case "/":{
                        stack.push((int) Math.floor((1.0d/(double) stack.pop())  * (double) stack.pop()));
                        break;
                    }
                    case "-":{
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    }

                }

            }
        System.out.println(stack.pop());

        }

    }
}
