package sprint3.A;
//https://neerc.ifmo.ru/wiki/index.php?title=Правильные_скобочные_последовательности
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(reader.readLine());
            createSequence(n, 0,0,"");
        }
    }

    static void createSequence(int n, int sumFront, int sumBack, String res){
        if (sumBack + sumFront == n * 2){
            System.out.println(res);
            return;
        }
        if (sumFront < n) {
            createSequence(n, sumFront+1, sumBack, res+"(");
        }
        if (sumFront > sumBack){
            createSequence(n, sumFront, sumBack+1, res + ")");
        }

    }


}
