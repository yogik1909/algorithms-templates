package sprint4.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class D {
    public static void main(String[] args) throws IOException {
        int a, m;
        String s;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            a = Integer.parseInt(reader.readLine());
            m = Integer.parseInt(reader.readLine());
            s = reader.readLine();
        }
        int indHas = Polynomial(s, a, m);

        System.out.println(indHas);


    }

    public static int Polynomial(String hasingString, int x, int mod) {
        BigInteger res = new BigInteger(String.valueOf(0));
        BigInteger mult = new BigInteger(String.valueOf(x));
        BigInteger modVal = new BigInteger(String.valueOf(mod));

        for (int i = 0; i < hasingString.length(); i++) {
            res = res.multiply(mult).add(BigInteger.valueOf(hasingString.charAt(i))).mod(modVal);
        }
        return Integer.parseInt(res.toString());
    }
}
