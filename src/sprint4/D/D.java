package sprint4.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    public static void main(String[] args) throws IOException {
        int a, m;
        String s;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            a = Integer.parseInt(reader.readLine());
            m = Integer.parseInt(reader.readLine());
            s = reader.readLine();
        }
        int indHas = Polynomial(s, a, m);

        System.out.println(indHas);


    }

    public static int Polynomial(String hasingString, int x, int mod) {
    long res = 0;

        for (int i = 0; i < hasingString.length(); i++){
            res = (res * x + hasingString.charAt(i)) % mod;
    }
    return (int) res;
    }
}
