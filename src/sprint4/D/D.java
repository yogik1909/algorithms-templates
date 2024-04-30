package sprint4.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class D {
    public static void main(String[] args) throws IOException {
        int a, m;
        String s;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            a = Integer.parseInt(reader.readLine());
            m = Integer.parseInt(reader.readLine());
            s = reader.readLine();
        }
        String has = Polynomial(s, a).mod(BigInteger.valueOf(m)).toString();

        System.out.println(has);


    }

    public static BigInteger Polynomial(String hasingString, int x) {
        BigInteger result = new BigInteger(String.valueOf((int) hasingString.charAt(0)));
        BigInteger xb = new BigInteger(Integer.valueOf(x).toString());
        for (int i = 1; i < hasingString.length(); i++) {
            result = result.multiply(xb).add(BigInteger.valueOf(hasingString.charAt(i))); // Применяем алгоритм Горнера
        }
        return result;
    }
}
