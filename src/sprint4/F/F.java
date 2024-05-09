package sprint4.F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
    static long[] powers;
    static long[] prefixHashes;
    public static void main(String[] args) throws IOException {
        int a, m, r;
        String s;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            a = Integer.parseInt(reader.readLine());
            m = Integer.parseInt(reader.readLine());
            s = reader.readLine();
            resPrefixPredata(s, a, m);
            r = Integer.parseInt(reader.readLine());
            for (int i = 0; i < r; i++) {
                String[] range = reader.readLine().split(" ");
                System.out.println(getSubStringHash(Integer.parseInt(range[0]) - 1, Integer.parseInt(range[1]), m));
            }
        }


    }

    static long getSubStringHash(int start, int end, int mod){
        long l = (prefixHashes[end] + mod - (prefixHashes[start] * powers[end - start]) % mod) % mod;
        return l;
    }
     static void resPrefixPredata(String s, int base, int mod){
        prefixHashes = new long[s.length()+1];
        powers = new long[s.length()+1];
        powers[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            prefixHashes[i] = (prefixHashes[i-1] * base % mod + s.charAt(i-1)) % mod;
            powers[i] = (powers[i-1] * base) % mod;
        }
    };


}
