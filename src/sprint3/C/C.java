package sprint3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class C {
    public static void main(String[] args) throws IOException {
        String set, subset;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            subset = reader.readLine();
            set = reader.readLine();
        }
        int[] ans = new int[subset.length()];
        Arrays.setAll(ans, a -> -1);
        int startIndSubSet = subset.length()/2;



    }

}
