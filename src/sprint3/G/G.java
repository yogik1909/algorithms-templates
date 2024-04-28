package sprint3.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {
    public static void main(String[] args) throws IOException {
        int n;
        String[] argz;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());
            if (n == 0) return;
            argz = reader.readLine().split(" ");
        }
        StringBuilder sb = new StringBuilder("");
        int[] counter = new int[3];
        for (String i:argz){
            counter[Integer.parseInt(i)]++;
        }
        for (int i = 0; i<3; i++){
            for (int j = 0; j < counter[i]; j++) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
