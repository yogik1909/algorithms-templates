package sprint3.H;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class H {
    public static void main(String[] args) throws IOException {
        int n;
        String[] argz;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            n = Integer.parseInt(reader.readLine());
            argz = reader.readLine().split(" ");
            Arrays.sort(argz, (l, r) -> Integer.parseInt(r+l) - Integer.parseInt(l+r));
            StringBuilder ans = new StringBuilder();
            for (String number : argz) {
                ans.append(number);
            }
            System.out.println(ans);
        }
    }
}
